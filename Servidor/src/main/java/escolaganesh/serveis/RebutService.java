package escolaganesh.serveis;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import escolaganesh.entitats.Alumne;
import escolaganesh.entitats.Comanda;
import escolaganesh.entitats.LiniaDetallRebut;
import escolaganesh.entitats.LiniaRebut;
import escolaganesh.entitats.Mensualitat;
import escolaganesh.entitats.Rebut;
import escolaganesh.models.LineaRebutDTO;
import escolaganesh.models.RebutDTO;
import escolaganesh.repositoris.AlumneRepository;
import escolaganesh.repositoris.ComandaRepository;
import escolaganesh.repositoris.LiniaDetallRebutRepository;
import escolaganesh.repositoris.LiniaRebutRepository;
import escolaganesh.repositoris.MensualitatRepository;
import escolaganesh.repositoris.RebutRepository;

@Service
public class RebutService {

    @Autowired
    private RebutRepository repository;
    @Autowired
    private MensualitatRepository repositoryMensualitat;
    @Autowired
    private ComandaRepository repositoryComanda;
    @Autowired
    private LiniaRebutRepository repositoryLinea;
    @Autowired
    private LiniaDetallRebutRepository repositoryDetall;
    @Autowired
    private AlumneRepository repositoryAlumne;

    public final static DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
    public final static DateFormat formatter_short = new SimpleDateFormat("yyyy-MM-dd");

    public RebutDTO get(int id) {
	Rebut rebut = repository.getOne(id);
	return toDTO(rebut);
    }

    public String create() {
	Integer year = new GregorianCalendar().get(Calendar.YEAR);
	Integer mes = new GregorianCalendar().get(Calendar.MONTH) + 1;

	Rebut resultat = null;
	List<Rebut> list = repository.findByMesAndYear(mes.toString(), year.toString());
	if (list != null && list.size() > 0) {
	    resultat = list.get(0);
	} else {
	    Rebut rebut = new Rebut();
	    rebut.setYear(year.toString());
	    rebut.setMes(mes.toString());
	    rebut.setValidat(false);
	    rebut.setLiniesRebut(new ArrayList<>());
	    rebut.setCreationDate(new Date());
	    rebut = repository.save(rebut);

	    List<Alumne> alumnes = repositoryAlumne.findByActiuTrue();
	    Double total = 0.0;
	    for (Alumne a : alumnes) {
		Double totalLinea = a.getCuota() == null ? 0.0 : a.getCuota();
		total += a.getCuota() == null ? 0.0 : a.getCuota();
		LiniaRebut linea = new LiniaRebut();
		linea.setAlumne(a);
		linea.setRebut(rebut);
		linea.setTotal(a.getCuota() == null ? 0.0 : a.getCuota());
		linea.setDetalls(new ArrayList<>());
		linea.setRetornat(false);
		linea = repositoryLinea.save(linea);
		rebut.getLiniesRebut().add(linea);
		// Primer detall = mensualitat
		Mensualitat dto = new Mensualitat();
		dto.setAlumne(linea.getAlumne());
		dto.setAny(Integer.parseInt(rebut.getYear()));
		dto.setMes(Integer.parseInt(rebut.getMes()));
		dto.setQuantitat(a.getCuota() == null ? 0.0 : a.getCuota());
		dto.setPagat(false);
		dto = repositoryMensualitat.save(dto);

		LiniaDetallRebut detall = new LiniaDetallRebut();
		detall.setDescripcio("Mensualitat " + mes + "/" + year);
		detall.setIdTipus(dto.getId());
		detall.setTipus(0);
		detall.setQuantitat(dto.getQuantitat());
		detall.setLiniaRebut(linea);
		detall = repositoryDetall.save(detall);
		linea.getDetalls().add(detall);
		// Altres detalls = comandes
		for (Comanda c : a.getComandes()) {
		    if (!c.getPagat()) {
			detall = new LiniaDetallRebut();
			detall.setDescripcio("Comanda material " + c.getMaterial().getDescripcio());
			detall.setTipus(1);
			detall.setIdTipus(c.getId());
			detall.setQuantitat(c.getPreuFinal());
			detall.setLiniaRebut(linea);
			detall = repositoryDetall.save(detall);
			c.setIdLiniaDetall(detall.getId());
			repositoryComanda.save(c);
			linea.getDetalls().add(detall);
			total += c.getPreuFinal();
			totalLinea += c.getPreuFinal();
		    }
		}
		linea.setTotal(totalLinea);
		linea = repositoryLinea.save(linea);
	    }
	    rebut.setTotal(total);
	    resultat = repository.save(rebut);
	}
	return genearateXML(resultat);
    }

    public void validar(int id) {
	Rebut rebut = repository.getOne(id);
	for (LiniaRebut linea : rebut.getLiniesRebut()) {
	    for (LiniaDetallRebut detall : linea.getDetalls()) {
		if (detall.getTipus().intValue() == 0) {
		    Mensualitat dto = repositoryMensualitat.getOne(detall.getIdTipus());
		    dto.setPagat(true);
		    repositoryMensualitat.save(dto);
		} else {
		    Comanda comanda = repositoryComanda.getOne(detall.getIdTipus());
		    comanda.setPagat(true);
		    repositoryComanda.save(comanda);
		}
	    }
	}
	rebut.setValidat(true);
	repository.save(rebut);
    }

    public void retornar(int idLinea) {
	LiniaRebut linea = repositoryLinea.getOne(idLinea);
	for (LiniaDetallRebut detall : linea.getDetalls()) {
	    if (detall.getTipus().intValue() == 0) {
		Mensualitat dto = repositoryMensualitat.getOne(detall.getIdTipus());
		dto.setPagat(false);
		repositoryMensualitat.save(dto);
	    } else {
		Comanda comanda = repositoryComanda.getOne(detall.getIdTipus());
		comanda.setPagat(false);
		repositoryComanda.save(comanda);
	    }
	}
	linea.setRetornat(true);
	repositoryLinea.save(linea);
    }

    public void refer(int idLinea) {
	LiniaRebut linea = repositoryLinea.getOne(idLinea);
	for (LiniaDetallRebut detall : linea.getDetalls()) {
	    if (detall.getTipus().intValue() == 0) {
		Mensualitat dto = repositoryMensualitat.getOne(detall.getIdTipus());
		dto.setPagat(true);
		repositoryMensualitat.save(dto);
	    } else {
		Comanda comanda = repositoryComanda.getOne(detall.getIdTipus());
		comanda.setPagat(true);
		repositoryComanda.save(comanda);
	    }
	}
	linea.setRetornat(false);
	repositoryLinea.save(linea);
    }

    public List<RebutDTO> findAll(String cercaMes, String cercaYear) {
	List<Rebut> allRebuts = null;
	if (cercaMes != null && cercaYear != null) {
	    allRebuts = repository.findByMesAndYear(cercaMes, cercaYear);
	} else if (cercaMes != null) {
	    allRebuts = repository.findByMes(cercaMes);
	} else if (cercaYear != null) {
	    allRebuts = repository.findByYear(cercaYear);
	} else {
	    allRebuts = repository.findAll();
	}

	List<RebutDTO> resultat = new ArrayList<>();
	for (Rebut a : allRebuts) {
	    resultat.add(toDTO(a));
	}
	return resultat;
    }

    private RebutDTO toDTO(Rebut rebut) {
	RebutDTO dto = new RebutDTO();
	dto.setId(rebut.getId());
	dto.setMes(rebut.getMes());
	dto.setYear(rebut.getYear());
	dto.setValidat(rebut.getValidat());
	List<LineaRebutDTO> linees = new ArrayList<>();
	for (LiniaRebut l : rebut.getLiniesRebut()) {
	    linees.add(toDTO(l, rebut.getId()));
	}
	dto.setLinees(linees);
	return dto;
    }

    private LineaRebutDTO toDTO(LiniaRebut linia, int idRebut) {
	LineaRebutDTO dto = new LineaRebutDTO();
	Alumne alumne = linia.getAlumne();
	dto.setAlumneId(alumne.getId());
	dto.setAlumneNom(alumne.getFirstName() + " " + alumne.getLastName());
	dto.setId(linia.getId());
	dto.setRebutId(idRebut);
	dto.setTotal(linia.getTotal());
	dto.setRetornat(Boolean.TRUE.equals(linia.getRetornat()));
	return dto;
    }

    private String genearateXML(Rebut rebut) {
	StringBuilder sb = new StringBuilder("{\"text\":\"<?xml version=\\\"1.0\\\" encoding=\\\"UTF-8\\\"?>");
	sb.append("<Document xmlns=\\\"urn:iso:std:iso:20022:tech:xsd:pain.008.001.02\\\" xmlns:xsi=\\\"http://www.w3.org/2001/XMLSchema-instance\\\">");
	sb.append("   <CstmrDrctDbtInitn>");
	sb.append("      <GrpHdr>");
	sb.append("         <MsgId>PRE2019071018595700042bsWindows9FD1</MsgId>");
	sb.append("         <CreDtTm>" + formatter.format(rebut.getCreationDate()) + "</CreDtTm>");
	sb.append("         <NbOfTxs>" + rebut.getLiniesRebut().size() + "</NbOfTxs>");
	sb.append("         <CtrlSum>" + rebut.getTotal() + "</CtrlSum>");
	sb.append("         <InitgPty>");
	sb.append("            <Nm>FRANCESC XAVIER GARCIA NAVARRO</Nm>");
	sb.append("            <Id>");
	sb.append("               <PrvtId>");
	sb.append("                  <Othr>");
	sb.append("                     <Id>ES9600052146785N</Id>");
	sb.append("                  </Othr>");
	sb.append("               </PrvtId>");
	sb.append("            </Id>");
	sb.append("         </InitgPty>");
	sb.append("      </GrpHdr>");
	sb.append("      <PmtInf>");
	sb.append("         <PmtInfId>20190710185957WD152146785N600</PmtInfId>");
	sb.append("         <PmtMtd>DD</PmtMtd>");
	sb.append("         <BtchBookg>false</BtchBookg>");
	sb.append("         <NbOfTxs>" + rebut.getLiniesRebut().size() + "</NbOfTxs>");
	sb.append("         <CtrlSum>" + rebut.getTotal() + "</CtrlSum>");
	sb.append("         <PmtTpInf>");
	sb.append("            <SvcLvl>");
	sb.append("               <Cd>SEPA</Cd>");
	sb.append("            </SvcLvl>");
	sb.append("            <LclInstrm>");
	sb.append("               <Cd>CORE</Cd>");
	sb.append("            </LclInstrm>");
	sb.append("            <SeqTp>RCUR</SeqTp>");
	sb.append("         </PmtTpInf>");
	sb.append("         <ReqdColltnDt>" + formatter_short.format(rebut.getCreationDate()) + "</ReqdColltnDt>");
	sb.append("         <Cdtr>");
	sb.append("            <Nm>FRANCESC XAVIER GARCIA NAVARRO</Nm>");
	sb.append("         </Cdtr>");
	sb.append("         <CdtrAcct>");
	sb.append("            <Id>");
	sb.append("               <IBAN>ES1800810031100001105419</IBAN>");
	sb.append("            </Id>");
	sb.append("         </CdtrAcct>");
	sb.append("         <CdtrAgt>");
	sb.append("            <FinInstnId>");
	sb.append("               <BIC>BSABESBBXXX</BIC>");
	sb.append("            </FinInstnId>");
	sb.append("         </CdtrAgt>");
	sb.append("         <CdtrSchmeId>");
	sb.append("            <Id>");
	sb.append("               <PrvtId>");
	sb.append("                  <Othr>");
	sb.append("                     <Id>ES9600052146785N</Id>");
	sb.append("                     <SchmeNm>");
	sb.append("                        <Prtry>SEPA</Prtry>");
	sb.append("                     </SchmeNm>");
	sb.append("                  </Othr>");
	sb.append("               </PrvtId>");
	sb.append("            </Id>");
	sb.append("         </CdtrSchmeId>");
	for (LiniaRebut linea : rebut.getLiniesRebut()) {
	    sb.append("         <DrctDbtTxInf>");
	    sb.append("            <PmtId>");
	    sb.append("               <EndToEndId>" + linea.getAlumne().getCid() + linea.getId() + "</EndToEndId>");
	    sb.append("            </PmtId>");
	    sb.append("            <InstdAmt Ccy=\\\"EUR\\\">" + linea.getTotal() + "</InstdAmt>");
	    sb.append("            <DrctDbtTx>");
	    sb.append("               <MndtRltdInf>");
	    sb.append("                  <MndtId>" + linea.getAlumne().getCid() + "</MndtId>");
	    sb.append("                  <DtOfSgntr>" + linea.getAlumne().getLastUpdate() + "</DtOfSgntr>");
	    sb.append("               </MndtRltdInf>");
	    sb.append("            </DrctDbtTx>");
	    sb.append("            <DbtrAgt>");
	    sb.append("               <FinInstnId />");
	    sb.append("            </DbtrAgt>");
	    sb.append("            <Dbtr>");
	    sb.append("               <Nm>" + linea.getAlumne().getFirstName() + " " + linea.getAlumne().getLastName() + "</Nm>");
	    sb.append("            </Dbtr>");
	    sb.append("            <DbtrAcct>");
	    sb.append("               <Id>");
	    sb.append("                  <IBAN>" + linea.getAlumne().getDadesBancaries() + "</IBAN>");
	    sb.append("               </Id>");
	    sb.append("            </DbtrAcct>");
	    sb.append("            <RmtInf>");
	    sb.append("               <Ustrd>ESCOLA GANESH</Ustrd>");
	    sb.append("            </RmtInf>");
	    sb.append("         </DrctDbtTxInf>");
	}
	sb.append("      </PmtInf>");
	sb.append("   </CstmrDrctDbtInitn>");
	sb.append("</Document>\"}");
	return sb.toString();
    }
}
