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
import escolaganesh.entitats.LiniaDetallRebut;
import escolaganesh.entitats.LiniaRebut;
import escolaganesh.entitats.Mensualitat;
import escolaganesh.entitats.Rebut;
import escolaganesh.models.RebutDTO;
import escolaganesh.repositoris.AlumneRepository;
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
    private LiniaRebutRepository repositoryLinea;
    @Autowired
    private LiniaDetallRebutRepository repositoryDetall;
    @Autowired
    private AlumneRepository repositoryAlumne;

    public final static DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
    public final static DateFormat formatter_short = new SimpleDateFormat("yyyy-MM-dd");

    public String create() {
	Integer year = new GregorianCalendar().get(Calendar.YEAR);
	Integer mes = new GregorianCalendar().get(Calendar.MONTH) + 1;

	List<Rebut> list = repository.findByMesAndYear(mes.toString(), year.toString());
	if (list != null && list.size() > 0) {
	    return "alreadyExists";
	}

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
	    total += a.getCuota() == null ? 0.0 : a.getCuota();
	    LiniaRebut linea = new LiniaRebut();
	    linea.setAlumne(a);
	    linea.setRebut(rebut);
	    linea.setTotal(a.getCuota() == null ? 0.0 : a.getCuota());
	    linea.setDetalls(new ArrayList<>());
	    linea = repositoryLinea.save(linea);
	    rebut.getLiniesRebut().add(linea);
	    // Primera linea = mensualitat
	    LiniaDetallRebut detall = new LiniaDetallRebut();
	    detall.setDescripcio("Mensualitat " + mes + "/" + year);
	    detall.setIdTipus(0);
	    detall.setTipus(0);
	    detall.setQuantitat(a.getCuota() == null ? 0.0 : a.getCuota());
	    detall.setLiniaRebut(linea);
	    detall = repositoryDetall.save(detall);
	    linea.getDetalls().add(detall);
	    // TODO: MIRAR COMANDES PENDENTS AQUI
	    // TODO: Actualitzar total de linea.
	}
	rebut.setTotal(total);
	repository.save(rebut);
	return genearateXML(rebut);
    }

    public void validar(int id) {
	Rebut rebut = repository.getOne(id);
	for (LiniaRebut linea : rebut.getLiniesRebut()) {
	    Mensualitat dto = new Mensualitat();
	    dto.setAlumne(linea.getAlumne());
	    dto.setAny(Integer.parseInt(rebut.getYear()));
	    dto.setMes(Integer.parseInt(rebut.getMes()));
	    for (LiniaDetallRebut detall : linea.getDetalls()) {
		// TODO: Check mensualitat from details
		dto.setQuantitat(detall.getQuantitat());
	    }
	    dto.setPagat(Boolean.TRUE);
	    repositoryMensualitat.save(dto);
	}
	rebut.setValidat(true);
	repository.save(rebut);
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

//	private Rebut toEntitat() {
//		Rebut rebut = new Rebut();
//		rebut.setMes(dto.getMes());
//		rebut.setYear(dto.getYear());
//		rebut.setValidat(dto.isValidat());
//		return rebut;
//	}

    private RebutDTO toDTO(Rebut mat) {
	RebutDTO dto = new RebutDTO();
	dto.setId(mat.getId());
	dto.setMes(mat.getMes());
	dto.setYear(mat.getYear());
	dto.setValidat(mat.getValidat());
	return dto;
    }

    private String genearateXML(Rebut rebut) {
	StringBuilder sb = new StringBuilder("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
	sb.append("<Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pain.008.001.02\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">");
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
	    sb.append("            <InstdAmt Ccy=\"EUR\">" + linea.getTotal() + "</InstdAmt>");
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
	sb.append("</Document>");
	return sb.toString();
    }
}
