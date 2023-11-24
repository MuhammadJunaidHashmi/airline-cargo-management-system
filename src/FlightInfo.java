
import java.text.SimpleDateFormat;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import static javax.management.Query.gt;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.TransferHandler;
import static javax.swing.TransferHandler.COPY_OR_MOVE;
import static javax.swing.TransferHandler.MOVE;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
import java.beans.XMLDecoder;
import java.util.Objects;
import javax.swing.JLabel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author dell
 */
public class FlightInfo extends javax.swing.JFrame implements Runnable {

    private Pattern pattern;
    String temp = null;
    int check = 0;
    int clicked = 0;
    int x, y; //for positing of title bar
    String reg = null;
    Connection con = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    String flight1 = "";
    String flight2 = "";
    String flight3 = "";
    String flight4 = "";
    String flight5 = "";
    String flight6 = "";
    String flight7 = "";
    String flight8 = "";
    String flight9 = "";
    String flight10 = "";
    String flight11 = "";
    String flight12 = "";
    String flight13 = "";
    String flight14 = "";
    String flight15 = "";
    String flight16 = "";
    String flight17 = "";
    String flight18 = "";
    String flight19 = "";
    String flight20 = "";
    String flight21 = "";
    String flight22 = "";
    String flight23 = "";
    String flight24 = "";
    String flight25 = "";

    int checkList = 0; //checkList is check the flight( like if the total no of flights is equal to 25 then checkList =1) 
    int hour, minute, second1;
    int countRow = 0;//for count the deadload row

    /**
     * Creates new form FlightInfo
     */
    public void backgroundDistributionBlock(javax.swing.JLabel j) {
        if (j.getName() == "A") {
            // JOptionPane.showMessageDialog(null, "ab");
            AB_panel.setBackground(new java.awt.Color(230, 230, 230));
            AA_panel.setBackground(new java.awt.Color(230, 230, 230));
            ABR_panel.setBackground(new java.awt.Color(230, 230, 230));
            ABL_panel.setBackground(new java.awt.Color(230, 230, 230));
            ABR.setText("");
            ABL.setText("");
            AA.setText("");
            AB.setText("");

        } else if (j.getName() == "B") {
            AB_panel.setBackground(new java.awt.Color(230, 230, 230));
            BC_panel.setBackground(new java.awt.Color(230, 230, 230));
            AA_panel.setBackground(new java.awt.Color(230, 230, 230));
            BB_panel.setBackground(new java.awt.Color(230, 230, 230));
            BCR_panel.setBackground(new java.awt.Color(230, 230, 230));
            BCL_panel.setBackground(new java.awt.Color(230, 230, 230));
            ABR_panel.setBackground(new java.awt.Color(230, 230, 230));
            ABL_panel.setBackground(new java.awt.Color(230, 230, 230));
            ABR.setText("");
            ABL.setText("");
            BCR.setText("");
            BCL.setText("");
            AA.setText("");
            AB.setText("");
            BB.setText("");
            BC.setText("");

        } else if (j.getName() == "C") {

            BB_panel.setBackground(new java.awt.Color(230, 230, 230));
            CC_panel.setBackground(new java.awt.Color(230, 230, 230));
            BCR_panel.setBackground(new java.awt.Color(230, 230, 230));
            BCL_panel.setBackground(new java.awt.Color(230, 230, 230));
            CEL_panel.setBackground(new java.awt.Color(230, 230, 230));
            CER_panel.setBackground(new java.awt.Color(230, 230, 230));
            CFG_panel.setBackground(new java.awt.Color(230, 230, 230));
            CFR_panel.setBackground(new java.awt.Color(230, 230, 230));
            BC_panel.setBackground(new java.awt.Color(230, 230, 230));
            CE_panel.setBackground(new java.awt.Color(230, 230, 230));
            BCR.setText("");
            BCL.setText("");
            CER.setText("");
            CEL.setText("");
            CFG.setText("");
            CFR.setText("");
            BB.setText("");
            CC.setText("");
            BC.setText("");
            CE.setText("");

        } else if (j.getName() == "D") {

            CC_panel.setBackground(new java.awt.Color(230, 230, 230));
            DD_panel.setBackground(new java.awt.Color(230, 230, 230));
            CEL_panel.setBackground(new java.awt.Color(230, 230, 230));
            CER_panel.setBackground(new java.awt.Color(230, 230, 230));
            CFG_panel.setBackground(new java.awt.Color(230, 230, 230));
            CFR_panel.setBackground(new java.awt.Color(230, 230, 230));
            CE_panel.setBackground(new java.awt.Color(230, 230, 230));
            CER.setText("");
            CEL.setText("");
            CFG.setText("");
            CFR.setText("");

            CC.setText("");
            DD.setText("");
            CE.setText("");

        } else if (j.getName() == "E") {

            EE_panel.setBackground(new java.awt.Color(230, 230, 230));
            DD_panel.setBackground(new java.awt.Color(230, 230, 230));
            CEL_panel.setBackground(new java.awt.Color(230, 230, 230));
            CER_panel.setBackground(new java.awt.Color(230, 230, 230));
            EFL_panel.setBackground(new java.awt.Color(230, 230, 230));
            EFR_panel.setBackground(new java.awt.Color(230, 230, 230));
            CFG_panel.setBackground(new java.awt.Color(230, 230, 230));
            CFR_panel.setBackground(new java.awt.Color(230, 230, 230));
            CE_panel.setBackground(new java.awt.Color(230, 230, 230));
            EF_panel.setBackground(new java.awt.Color(230, 230, 230));
            CER.setText("");
            CEL.setText("");
            EFR.setText("");
            EFL.setText("");
            CFG.setText("");
            CFR.setText("");

            EE.setText("");
            DD.setText("");
            CE.setText("");
            EF.setText("");

        } else if (j.getName() == "F") {
            EE_panel.setBackground(new java.awt.Color(230, 230, 230));
            FF_panel.setBackground(new java.awt.Color(230, 230, 230));
            EFL_panel.setBackground(new java.awt.Color(230, 230, 230));
            EFR_panel.setBackground(new java.awt.Color(230, 230, 230));
            FHL_panel.setBackground(new java.awt.Color(230, 230, 230));
            FHR_panel.setBackground(new java.awt.Color(230, 230, 230));
            CFG_panel.setBackground(new java.awt.Color(230, 230, 230));
            CFR_panel.setBackground(new java.awt.Color(230, 230, 230));
            FJG_panel.setBackground(new java.awt.Color(230, 230, 230));
            FJR_panel.setBackground(new java.awt.Color(230, 230, 230));
            EF_panel.setBackground(new java.awt.Color(230, 230, 230));
            FH_panel.setBackground(new java.awt.Color(230, 230, 230));

            EFR.setText("");
            EFL.setText("");
            FHR.setText("");
            FHL.setText("");
            CFG.setText("");
            CFR.setText("");
            FJG.setText("");
            FJR.setText("");

            EE.setText("");
            FF.setText("");
            EF.setText("");
            FH.setText("");

        } else if (j.getName() == "G") {
            GG_panel.setBackground(new java.awt.Color(230, 230, 230));
            FF_panel.setBackground(new java.awt.Color(230, 230, 230));
            FHL_panel.setBackground(new java.awt.Color(230, 230, 230));
            FHR_panel.setBackground(new java.awt.Color(230, 230, 230));
            FJG_panel.setBackground(new java.awt.Color(230, 230, 230));
            FJR_panel.setBackground(new java.awt.Color(230, 230, 230));
            FH_panel.setBackground(new java.awt.Color(230, 230, 230));

            FHR.setText("");
            FHL.setText("");
            FJG.setText("");
            FJR.setText("");

            GG.setText("");
            FF.setText("");
            FH.setText("");

        } else if (j.getName() == "H") {
            GG_panel.setBackground(new java.awt.Color(230, 230, 230));
            HH_panel.setBackground(new java.awt.Color(230, 230, 230));
            FHL_panel.setBackground(new java.awt.Color(230, 230, 230));
            FHR_panel.setBackground(new java.awt.Color(230, 230, 230));
            HJL_panel.setBackground(new java.awt.Color(230, 230, 230));
            HJR_panel.setBackground(new java.awt.Color(230, 230, 230));
            FJG_panel.setBackground(new java.awt.Color(230, 230, 230));
            FJR_panel.setBackground(new java.awt.Color(230, 230, 230));
            JLR_panel.setBackground(new java.awt.Color(230, 230, 230));
            FH_panel.setBackground(new java.awt.Color(230, 230, 230));
            HJ_panel.setBackground(new java.awt.Color(230, 230, 230));

            FHR.setText("");
            FHL.setText("");
            HJR.setText("");
            HJL.setText("");
            FJG.setText("");
            FJR.setText("");
            JLR.setText("");
            GG.setText("");
            HH.setText("");
            FH.setText("");
            HJ.setText("");

        } else if (j.getName() == "J") {
            JJ_panel.setBackground(new java.awt.Color(230, 230, 230));
            HH_panel.setBackground(new java.awt.Color(230, 230, 230));
            JKL_panel.setBackground(new java.awt.Color(230, 230, 230));
            JKR_panel.setBackground(new java.awt.Color(230, 230, 230));
            HJL_panel.setBackground(new java.awt.Color(230, 230, 230));
            HJR_panel.setBackground(new java.awt.Color(230, 230, 230));
            FJG_panel.setBackground(new java.awt.Color(230, 230, 230));
            JLR_panel.setBackground(new java.awt.Color(230, 230, 230));
            JLG_panel.setBackground(new java.awt.Color(230, 230, 230));
            JK_panel.setBackground(new java.awt.Color(230, 230, 230));
            HJ_panel.setBackground(new java.awt.Color(230, 230, 230));

            JKR.setText("");
            JKL.setText("");
            HJR.setText("");
            HJL.setText("");
            FJG.setText("");
            JLG.setText("");
            JLR.setText("");
            JJ.setText("");
            HH.setText("");
            JK.setText("");
            HJ.setText("");

        } else if (j.getName() == "K") {
            JJ_panel.setBackground(new java.awt.Color(230, 230, 230));
            KK_panel.setBackground(new java.awt.Color(230, 230, 230));
            JKL_panel.setBackground(new java.awt.Color(230, 230, 230));
            JKR_panel.setBackground(new java.awt.Color(230, 230, 230));
            KML_panel.setBackground(new java.awt.Color(230, 230, 230));
            KMR_panel.setBackground(new java.awt.Color(230, 230, 230));
            JLR_panel.setBackground(new java.awt.Color(230, 230, 230));
            JLG_panel.setBackground(new java.awt.Color(230, 230, 230));
            JK_panel.setBackground(new java.awt.Color(230, 230, 230));
            KM_panel.setBackground(new java.awt.Color(230, 230, 230));

            JKR.setText("");
            JKL.setText("");
            KMR.setText("");
            KML.setText("");
            JLG.setText("");
            JLR.setText("");
            JJ.setText("");
            KK.setText("");
            JK.setText("");
            KM.setText("");

        } else if (j.getName() == "L") {
            LL_panel.setBackground(new java.awt.Color(230, 230, 230));
            KK_panel.setBackground(new java.awt.Color(230, 230, 230));
            KML_panel.setBackground(new java.awt.Color(230, 230, 230));
            KMR_panel.setBackground(new java.awt.Color(230, 230, 230));
            JLR_panel.setBackground(new java.awt.Color(230, 230, 230));
            LPR_panel.setBackground(new java.awt.Color(230, 230, 230));
            JLG_panel.setBackground(new java.awt.Color(230, 230, 230));
            KM_panel.setBackground(new java.awt.Color(230, 230, 230));

            KMR.setText("");
            KML.setText("");
            JLG.setText("");
            JLR.setText("");
            LPR.setText("");
            LL.setText("");
            KK.setText("");
            KM.setText("");

        } else if (j.getName() == "M") {
            LL_panel.setBackground(new java.awt.Color(230, 230, 230));
            KML_panel.setBackground(new java.awt.Color(230, 230, 230));
            KMR_panel.setBackground(new java.awt.Color(230, 230, 230));
            MPL_panel.setBackground(new java.awt.Color(230, 230, 230));
            MPR_panel.setBackground(new java.awt.Color(230, 230, 230));
            LPR_panel.setBackground(new java.awt.Color(230, 230, 230));
            KM_panel.setBackground(new java.awt.Color(230, 230, 230));
            MP_panel.setBackground(new java.awt.Color(230, 230, 230));

            KMR.setText("");
            KML.setText("");
            MPR.setText("");
            MPL.setText("");
            LPR.setText("");
            LL.setText("");
            MP.setText("");
            KM.setText("");

        } else if (j.getName() == "P") {
            MM_panel.setBackground(new java.awt.Color(230, 230, 230));
            PRL_panel.setBackground(new java.awt.Color(230, 230, 230));
            PRR_panel.setBackground(new java.awt.Color(230, 230, 230));
            MPL_panel.setBackground(new java.awt.Color(230, 230, 230));
            MPR_panel.setBackground(new java.awt.Color(230, 230, 230));
            LPR_panel.setBackground(new java.awt.Color(230, 230, 230));
            MP_panel.setBackground(new java.awt.Color(230, 230, 230));

            PRR.setText("");
            PRL.setText("");
            MPR.setText("");
            MPL.setText("");
            LPR.setText("");
            MM.setText("");
            MP.setText("");

        } else if (j.getName() == "R") {
            PP_panel.setBackground(new java.awt.Color(230, 230, 230));
            PRL_panel.setBackground(new java.awt.Color(230, 230, 230));
            PRR_panel.setBackground(new java.awt.Color(230, 230, 230));

            PRR.setText("");
            PRL.setText("");
            PP.setText("");

        } else if (j.getName() == "S") {
            RR_panel.setBackground(new java.awt.Color(230, 230, 230));
            RR.setText("");

        } else if (j.getName() == "T") {
            SS_panel.setBackground(new java.awt.Color(230, 230, 230));
            SS.setText("");

        } else if (j.getName() == "U") {
            TT_panel.setBackground(new java.awt.Color(230, 230, 230));
            TT.setText("");

        }

        if (j.getName() == "AA") {
            // JOptionPane.showMessageDialog(null, "ab");
            AB_panel.setBackground(new java.awt.Color(230, 230, 230));
            A_panel.setBackground(new java.awt.Color(230, 230, 230));
            B_panel.setBackground(new java.awt.Color(230, 230, 230));
            ABR_panel.setBackground(new java.awt.Color(230, 230, 230));
            ABL_panel.setBackground(new java.awt.Color(230, 230, 230));
            ABR.setText("");
            ABL.setText("");
            A.setText("");
            B.setText("");
            AB.setText("");

        } else if (j.getName() == "BB") {

            B_panel.setBackground(new java.awt.Color(230, 230, 230));
            C_panel.setBackground(new java.awt.Color(230, 230, 230));
            BCR_panel.setBackground(new java.awt.Color(230, 230, 230));
            BCL_panel.setBackground(new java.awt.Color(230, 230, 230));
            ABL_panel.setBackground(new java.awt.Color(230, 230, 230));
            ABR_panel.setBackground(new java.awt.Color(230, 230, 230));
            BC_panel.setBackground(new java.awt.Color(230, 230, 230));
            AB_panel.setBackground(new java.awt.Color(230, 230, 230));
            BCR.setText("");
            BCL.setText("");
            ABR.setText("");
            ABL.setText("");
            B.setText("");
            C.setText("");
            BC.setText("");
            AB.setText("");

        } else if (j.getName() == "CC") {

            C_panel.setBackground(new java.awt.Color(230, 230, 230));
            D_panel.setBackground(new java.awt.Color(230, 230, 230));
            CEL_panel.setBackground(new java.awt.Color(230, 230, 230));
            CER_panel.setBackground(new java.awt.Color(230, 230, 230));
            BCL_panel.setBackground(new java.awt.Color(230, 230, 230));
            BCR_panel.setBackground(new java.awt.Color(230, 230, 230));
            CFG_panel.setBackground(new java.awt.Color(230, 230, 230));
            CFR_panel.setBackground(new java.awt.Color(230, 230, 230));
            CE_panel.setBackground(new java.awt.Color(230, 230, 230));
            BC_panel.setBackground(new java.awt.Color(230, 230, 230));
            CER.setText("");
            CEL.setText("");
            BCR.setText("");
            BCL.setText("");
            CFG.setText("");
            CFR.setText("");
            C.setText("");
            D.setText("");
            CE.setText("");
            BC.setText("");

        } else if (j.getName() == "DD") {

            E_panel.setBackground(new java.awt.Color(230, 230, 230));
            D_panel.setBackground(new java.awt.Color(230, 230, 230));
            CEL_panel.setBackground(new java.awt.Color(230, 230, 230));
            CER_panel.setBackground(new java.awt.Color(230, 230, 230));
            EFL_panel.setBackground(new java.awt.Color(230, 230, 230));
            EFR_panel.setBackground(new java.awt.Color(230, 230, 230));
            CFG_panel.setBackground(new java.awt.Color(230, 230, 230));
            CFR_panel.setBackground(new java.awt.Color(230, 230, 230));
            CE_panel.setBackground(new java.awt.Color(230, 230, 230));
            EF_panel.setBackground(new java.awt.Color(230, 230, 230));
            CER.setText("");
            CEL.setText("");
            EFR.setText("");
            EFL.setText("");
            CFG.setText("");
            CFR.setText("");
            E.setText("");
            D.setText("");
            CE.setText("");
            EF.setText("");

        } else if (j.getName() == "EE") {
            E_panel.setBackground(new java.awt.Color(230, 230, 230));
            F_panel.setBackground(new java.awt.Color(230, 230, 230));
            EFL_panel.setBackground(new java.awt.Color(230, 230, 230));
            EFR_panel.setBackground(new java.awt.Color(230, 230, 230));
            CFG_panel.setBackground(new java.awt.Color(230, 230, 230));
            CFR_panel.setBackground(new java.awt.Color(230, 230, 230));
            EF_panel.setBackground(new java.awt.Color(230, 230, 230));

            EFR.setText("");
            EFL.setText("");
            CFG.setText("");
            CFR.setText("");
            EF.setText("");
            E.setText("");
            F.setText("");

        } else if (j.getName() == "FF") {
            G_panel.setBackground(new java.awt.Color(230, 230, 230));
            F_panel.setBackground(new java.awt.Color(230, 230, 230));
            FHL_panel.setBackground(new java.awt.Color(230, 230, 230));
            FHR_panel.setBackground(new java.awt.Color(230, 230, 230));
            EFL_panel.setBackground(new java.awt.Color(230, 230, 230));
            EFR_panel.setBackground(new java.awt.Color(230, 230, 230));
            FJG_panel.setBackground(new java.awt.Color(230, 230, 230));
            CFG_panel.setBackground(new java.awt.Color(230, 230, 230));
            FJR_panel.setBackground(new java.awt.Color(230, 230, 230));
            FH_panel.setBackground(new java.awt.Color(230, 230, 230));
            EF_panel.setBackground(new java.awt.Color(230, 230, 230));

            FHR.setText("");
            FHL.setText("");
            EFR.setText("");
            EFL.setText("");
            FJG.setText("");
            CFG.setText("");
            FJR.setText("");
            G.setText("");
            F.setText("");
            FH.setText("");
            EF.setText("");

        } else if (j.getName() == "GG") {
            G_panel.setBackground(new java.awt.Color(230, 230, 230));
            H_panel.setBackground(new java.awt.Color(230, 230, 230));
            FHL_panel.setBackground(new java.awt.Color(230, 230, 230));
            FHR_panel.setBackground(new java.awt.Color(230, 230, 230));
            HJL_panel.setBackground(new java.awt.Color(230, 230, 230));
            HJR_panel.setBackground(new java.awt.Color(230, 230, 230));
            FJG_panel.setBackground(new java.awt.Color(230, 230, 230));
            FJR_panel.setBackground(new java.awt.Color(230, 230, 230));
            FH_panel.setBackground(new java.awt.Color(230, 230, 230));
            HJ_panel.setBackground(new java.awt.Color(230, 230, 230));

            FHR.setText("");
            FHL.setText("");
            HJR.setText("");
            HJL.setText("");
            FJG.setText("");
            FJR.setText("");
            G.setText("");
            H.setText("");
            FH.setText("");
            HJ.setText("");

        } else if (j.getName() == "HH") {
            J_panel.setBackground(new java.awt.Color(230, 230, 230));
            H_panel.setBackground(new java.awt.Color(230, 230, 230));
            JKL_panel.setBackground(new java.awt.Color(230, 230, 230));
            JKR_panel.setBackground(new java.awt.Color(230, 230, 230));
            HJL_panel.setBackground(new java.awt.Color(230, 230, 230));
            HJR_panel.setBackground(new java.awt.Color(230, 230, 230));
            FJG_panel.setBackground(new java.awt.Color(230, 230, 230));
            JLR_panel.setBackground(new java.awt.Color(230, 230, 230));
            JLG_panel.setBackground(new java.awt.Color(230, 230, 230));
            JK_panel.setBackground(new java.awt.Color(230, 230, 230));
            HJ_panel.setBackground(new java.awt.Color(230, 230, 230));

            JKR.setText("");
            JKL.setText("");
            HJR.setText("");
            HJL.setText("");
            FJG.setText("");
            JLG.setText("");
            JLR.setText("");
            J.setText("");
            H.setText("");
            JK.setText("");
            HJ.setText("");

        } else if (j.getName() == "JJ") {
            J_panel.setBackground(new java.awt.Color(230, 230, 230));
            K_panel.setBackground(new java.awt.Color(230, 230, 230));
            JKL_panel.setBackground(new java.awt.Color(230, 230, 230));
            JKR_panel.setBackground(new java.awt.Color(230, 230, 230));
            JLR_panel.setBackground(new java.awt.Color(230, 230, 230));
            JLG_panel.setBackground(new java.awt.Color(230, 230, 230));
            JK_panel.setBackground(new java.awt.Color(230, 230, 230));

            JKR.setText("");
            JKL.setText("");
            JLG.setText("");
            JLR.setText("");
            J.setText("");
            K.setText("");
            JK.setText("");

        } else if (j.getName() == "KK") {
            L_panel.setBackground(new java.awt.Color(230, 230, 230));
            K_panel.setBackground(new java.awt.Color(230, 230, 230));
            KML_panel.setBackground(new java.awt.Color(230, 230, 230));
            KMR_panel.setBackground(new java.awt.Color(230, 230, 230));
            JKL_panel.setBackground(new java.awt.Color(230, 230, 230));
            JKR_panel.setBackground(new java.awt.Color(230, 230, 230));
            JLR_panel.setBackground(new java.awt.Color(230, 230, 230));
            LPR_panel.setBackground(new java.awt.Color(230, 230, 230));
            JLG_panel.setBackground(new java.awt.Color(230, 230, 230));
            KM_panel.setBackground(new java.awt.Color(230, 230, 230));
            JK_panel.setBackground(new java.awt.Color(230, 230, 230));

            KMR.setText("");
            KML.setText("");
            JKR.setText("");
            JKL.setText("");
            JLG.setText("");
            JLR.setText("");
            LPR.setText("");
            L.setText("");
            K.setText("");
            KM.setText("");
            JK.setText("");

        } else if (j.getName() == "LL") {
            L_panel.setBackground(new java.awt.Color(230, 230, 230));
            M_panel.setBackground(new java.awt.Color(230, 230, 230));
            KML_panel.setBackground(new java.awt.Color(230, 230, 230));
            KMR_panel.setBackground(new java.awt.Color(230, 230, 230));
            MPL_panel.setBackground(new java.awt.Color(230, 230, 230));
            MPR_panel.setBackground(new java.awt.Color(230, 230, 230));
            LPR_panel.setBackground(new java.awt.Color(230, 230, 230));
            JLG_panel.setBackground(new java.awt.Color(230, 230, 230));
            KM_panel.setBackground(new java.awt.Color(230, 230, 230));
            MP_panel.setBackground(new java.awt.Color(230, 230, 230));

            KMR.setText("");
            KML.setText("");
            MPR.setText("");
            MPL.setText("");
            LPR.setText("");
            JLG.setText("");
            L.setText("");
            M.setText("");
            MP.setText("");
            KM.setText("");

        } else if (j.getName() == "MM") {
            P_panel.setBackground(new java.awt.Color(230, 230, 230));
            PRL_panel.setBackground(new java.awt.Color(230, 230, 230));
            PRR_panel.setBackground(new java.awt.Color(230, 230, 230));
            MPL_panel.setBackground(new java.awt.Color(230, 230, 230));
            MPR_panel.setBackground(new java.awt.Color(230, 230, 230));
            LPR_panel.setBackground(new java.awt.Color(230, 230, 230));
            MP_panel.setBackground(new java.awt.Color(230, 230, 230));

            PRR.setText("");
            PRL.setText("");
            MPR.setText("");
            MPL.setText("");
            LPR.setText("");
            P.setText("");
            MP.setText("");

        } else if (j.getName() == "PP") {
            R_panel.setBackground(new java.awt.Color(230, 230, 230));
            PRL_panel.setBackground(new java.awt.Color(230, 230, 230));
            PRR_panel.setBackground(new java.awt.Color(230, 230, 230));

            PRR.setText("");
            PRL.setText("");
            R.setText("");

        } else if (j.getName() == "RR") {
            S_panel.setBackground(new java.awt.Color(230, 230, 230));
            S.setText("");

        } else if (j.getName() == "SS") {
            T_panel.setBackground(new java.awt.Color(230, 230, 230));
            T.setText("");

        } else if (j.getName() == "TT") {
            U_panel.setBackground(new java.awt.Color(230, 230, 230));
            U.setText("");

        } else if (j.getName() == "AB") {
            // JOptionPane.showMessageDialog(null, "ab");
            A_panel.setBackground(new java.awt.Color(230, 230, 230));
            B_panel.setBackground(new java.awt.Color(230, 230, 230));
            AA_panel.setBackground(new java.awt.Color(230, 230, 230));
            BB_panel.setBackground(new java.awt.Color(230, 230, 230));
            ABR_panel.setBackground(new java.awt.Color(230, 230, 230));
            ABL_panel.setBackground(new java.awt.Color(230, 230, 230));
            ABR.setText("");
            ABL.setText("");
            A.setText("");
            B.setText("");
            AA.setText("");
            BB.setText("");

        } else if (j.getName() == "BC") {
            B_panel.setBackground(new java.awt.Color(230, 230, 230));
            C_panel.setBackground(new java.awt.Color(230, 230, 230));
            BB_panel.setBackground(new java.awt.Color(230, 230, 230));
            CC_panel.setBackground(new java.awt.Color(230, 230, 230));
            BCR_panel.setBackground(new java.awt.Color(230, 230, 230));
            BCL_panel.setBackground(new java.awt.Color(230, 230, 230));
            BCR.setText("");
            BCL.setText("");
            C.setText("");
            B.setText("");
            CC.setText("");
            BB.setText("");
        } else if (j.getName() == "CE") {
            C_panel.setBackground(new java.awt.Color(230, 230, 230));
            D_panel.setBackground(new java.awt.Color(230, 230, 230));
            E_panel.setBackground(new java.awt.Color(230, 230, 230));
            CC_panel.setBackground(new java.awt.Color(230, 230, 230));
            DD_panel.setBackground(new java.awt.Color(230, 230, 230));
            CER_panel.setBackground(new java.awt.Color(230, 230, 230));
            CEL_panel.setBackground(new java.awt.Color(230, 230, 230));
            CFG_panel.setBackground(new java.awt.Color(230, 230, 230));
            CFR_panel.setBackground(new java.awt.Color(230, 230, 230));

            CER.setText("");
            CEL.setText("");
            CFG.setText("");
            CFR.setText("");
            C.setText("");
            D.setText("");
            E.setText("");
            CC.setText("");
            DD.setText("");
        } else if (j.getName() == "EF") {
            // JOptionPane.showMessageDialog(null, "ab");
            E_panel.setBackground(new java.awt.Color(230, 230, 230));
            F_panel.setBackground(new java.awt.Color(230, 230, 230));
            DD_panel.setBackground(new java.awt.Color(230, 230, 230));
            EE_panel.setBackground(new java.awt.Color(230, 230, 230));
            FF_panel.setBackground(new java.awt.Color(230, 230, 230));
            EFR_panel.setBackground(new java.awt.Color(230, 230, 230));
            EFL_panel.setBackground(new java.awt.Color(230, 230, 230));
            CFG_panel.setBackground(new java.awt.Color(230, 230, 230));
            CFR_panel.setBackground(new java.awt.Color(230, 230, 230));

            EFR.setText("");
            EFL.setText("");
            CFG.setText("");
            CFR.setText("");
            E.setText("");
            F.setText("");
            DD.setText("");
            EE.setText("");
            FF.setText("");

        } else if (j.getName() == "FH") {
            F_panel.setBackground(new java.awt.Color(230, 230, 230));
            G_panel.setBackground(new java.awt.Color(230, 230, 230));
            H_panel.setBackground(new java.awt.Color(230, 230, 230));
            FF_panel.setBackground(new java.awt.Color(230, 230, 230));
            GG_panel.setBackground(new java.awt.Color(230, 230, 230));
            FHR_panel.setBackground(new java.awt.Color(230, 230, 230));
            FHL_panel.setBackground(new java.awt.Color(230, 230, 230));
            FJG_panel.setBackground(new java.awt.Color(230, 230, 230));
            FJR_panel.setBackground(new java.awt.Color(230, 230, 230));

            FHR.setText("");
            FHL.setText("");
            FJG.setText("");
            FJR.setText("");
            F.setText("");
            G.setText("");
            H.setText("");
            FF.setText("");
            GG.setText("");
        } else if (j.getName() == "HJ") {
            H_panel.setBackground(new java.awt.Color(230, 230, 230));
            J_panel.setBackground(new java.awt.Color(230, 230, 230));
            GG_panel.setBackground(new java.awt.Color(230, 230, 230));
            HH_panel.setBackground(new java.awt.Color(230, 230, 230));
            HJR_panel.setBackground(new java.awt.Color(230, 230, 230));
            HJL_panel.setBackground(new java.awt.Color(230, 230, 230));
            FJG_panel.setBackground(new java.awt.Color(230, 230, 230));
            FJR_panel.setBackground(new java.awt.Color(230, 230, 230));
            JLR_panel.setBackground(new java.awt.Color(230, 230, 230));

            HJR.setText("");
            HJL.setText("");
            FJG.setText("");
            FJR.setText("");
            JLR.setText("");
            H.setText("");
            J.setText("");
            GG.setText("");
            HH.setText("");
        } else if (j.getName() == "JK") {
            J_panel.setBackground(new java.awt.Color(230, 230, 230));
            K_panel.setBackground(new java.awt.Color(230, 230, 230));
            HH_panel.setBackground(new java.awt.Color(230, 230, 230));
            JJ_panel.setBackground(new java.awt.Color(230, 230, 230));
            KK_panel.setBackground(new java.awt.Color(230, 230, 230));
            JKR_panel.setBackground(new java.awt.Color(230, 230, 230));
            JKL_panel.setBackground(new java.awt.Color(230, 230, 230));
            JLG_panel.setBackground(new java.awt.Color(230, 230, 230));
            JLR_panel.setBackground(new java.awt.Color(230, 230, 230));

            JKR.setText("");
            JKL.setText("");
            JLG.setText("");
            JLR.setText("");
            J.setText("");
            K.setText("");
            HH.setText("");
            JJ.setText("");
            KK.setText("");
        } else if (j.getName() == "KM") {
            K_panel.setBackground(new java.awt.Color(230, 230, 230));
            L_panel.setBackground(new java.awt.Color(230, 230, 230));
            M_panel.setBackground(new java.awt.Color(230, 230, 230));
            KK_panel.setBackground(new java.awt.Color(230, 230, 230));
            LL_panel.setBackground(new java.awt.Color(230, 230, 230));
            KMR_panel.setBackground(new java.awt.Color(230, 230, 230));
            KML_panel.setBackground(new java.awt.Color(230, 230, 230));
            JLG_panel.setBackground(new java.awt.Color(230, 230, 230));
            JLR_panel.setBackground(new java.awt.Color(230, 230, 230));
            LPR_panel.setBackground(new java.awt.Color(230, 230, 230));

            KMR.setText("");
            KML.setText("");
            JLG.setText("");
            JLR.setText("");
            LPR.setText("");
            K.setText("");
            L.setText("");
            M.setText("");
            KK.setText("");
            LL.setText("");
        } else if (j.getName() == "MP") {
            M_panel.setBackground(new java.awt.Color(230, 230, 230));
            P_panel.setBackground(new java.awt.Color(230, 230, 230));
            LL_panel.setBackground(new java.awt.Color(230, 230, 230));
            MM_panel.setBackground(new java.awt.Color(230, 230, 230));
            MPR_panel.setBackground(new java.awt.Color(230, 230, 230));
            MPL_panel.setBackground(new java.awt.Color(230, 230, 230));
            LPR_panel.setBackground(new java.awt.Color(230, 230, 230));

            MPR.setText("");
            MPL.setText("");
            LPR.setText("");
            M.setText("");
            P.setText("");
            LL.setText("");
            MM.setText("");

        } else if (j.getName() == "ABR" || j.getName() == "ABL") {
            // JOptionPane.showMessageDialog(null, "ab");
            A_panel.setBackground(new java.awt.Color(230, 230, 230));
            B_panel.setBackground(new java.awt.Color(230, 230, 230));
            AA_panel.setBackground(new java.awt.Color(230, 230, 230));
            BB_panel.setBackground(new java.awt.Color(230, 230, 230));
            AB_panel.setBackground(new java.awt.Color(230, 230, 230));
            AB.setText("");
            A.setText("");
            B.setText("");
            AA.setText("");
            BB.setText("");

        } else if (j.getName() == "BCR" || j.getName() == "BCL") {
            B_panel.setBackground(new java.awt.Color(230, 230, 230));
            C_panel.setBackground(new java.awt.Color(230, 230, 230));
            BB_panel.setBackground(new java.awt.Color(230, 230, 230));
            CC_panel.setBackground(new java.awt.Color(230, 230, 230));
            BC_panel.setBackground(new java.awt.Color(230, 230, 230));
            BC.setText("");
            C.setText("");
            B.setText("");
            CC.setText("");
            BB.setText("");
        } else if (j.getName() == "CER" || j.getName() == "CEL") {
            C_panel.setBackground(new java.awt.Color(230, 230, 230));
            D_panel.setBackground(new java.awt.Color(230, 230, 230));
            E_panel.setBackground(new java.awt.Color(230, 230, 230));
            CC_panel.setBackground(new java.awt.Color(230, 230, 230));
            DD_panel.setBackground(new java.awt.Color(230, 230, 230));
            CE_panel.setBackground(new java.awt.Color(230, 230, 230));
            CFG_panel.setBackground(new java.awt.Color(230, 230, 230));
            CFR_panel.setBackground(new java.awt.Color(230, 230, 230));

            CE.setText("");
            CFG.setText("");
            CFR.setText("");
            C.setText("");
            D.setText("");
            E.setText("");
            CC.setText("");
            DD.setText("");
        } else if (j.getName() == "EFR" || j.getName() == "EFL") {
            // JOptionPane.showMessageDialog(null, "ab");
            E_panel.setBackground(new java.awt.Color(230, 230, 230));
            F_panel.setBackground(new java.awt.Color(230, 230, 230));
            DD_panel.setBackground(new java.awt.Color(230, 230, 230));
            EE_panel.setBackground(new java.awt.Color(230, 230, 230));
            FF_panel.setBackground(new java.awt.Color(230, 230, 230));
            EF_panel.setBackground(new java.awt.Color(230, 230, 230));
            CFG_panel.setBackground(new java.awt.Color(230, 230, 230));
            CFR_panel.setBackground(new java.awt.Color(230, 230, 230));

            EF.setText("");
            CFG.setText("");
            CFR.setText("");
            E.setText("");
            F.setText("");
            DD.setText("");
            EE.setText("");
            FF.setText("");

        } else if (j.getName() == "FHR" || j.getName() == "FHL") {
            F_panel.setBackground(new java.awt.Color(230, 230, 230));
            G_panel.setBackground(new java.awt.Color(230, 230, 230));
            H_panel.setBackground(new java.awt.Color(230, 230, 230));
            FF_panel.setBackground(new java.awt.Color(230, 230, 230));
            GG_panel.setBackground(new java.awt.Color(230, 230, 230));
            FH_panel.setBackground(new java.awt.Color(230, 230, 230));
            FJG_panel.setBackground(new java.awt.Color(230, 230, 230));
            FJR_panel.setBackground(new java.awt.Color(230, 230, 230));

            FH.setText("");
            FJG.setText("");
            FJR.setText("");
            F.setText("");
            G.setText("");
            H.setText("");
            FF.setText("");
            GG.setText("");
        } else if (j.getName() == "HJR" || j.getName() == "HJL") {
            H_panel.setBackground(new java.awt.Color(230, 230, 230));
            J_panel.setBackground(new java.awt.Color(230, 230, 230));
            GG_panel.setBackground(new java.awt.Color(230, 230, 230));
            HH_panel.setBackground(new java.awt.Color(230, 230, 230));
            HJ_panel.setBackground(new java.awt.Color(230, 230, 230));
            FJG_panel.setBackground(new java.awt.Color(230, 230, 230));
            FJR_panel.setBackground(new java.awt.Color(230, 230, 230));
            JLR_panel.setBackground(new java.awt.Color(230, 230, 230));

            HJ.setText("");
            FJG.setText("");
            FJR.setText("");
            JLR.setText("");
            H.setText("");
            J.setText("");
            GG.setText("");
            HH.setText("");
        } else if (j.getName() == "JKR" || j.getName() == "JKL") {
            J_panel.setBackground(new java.awt.Color(230, 230, 230));
            K_panel.setBackground(new java.awt.Color(230, 230, 230));
            HH_panel.setBackground(new java.awt.Color(230, 230, 230));
            JJ_panel.setBackground(new java.awt.Color(230, 230, 230));
            KK_panel.setBackground(new java.awt.Color(230, 230, 230));
            JK_panel.setBackground(new java.awt.Color(230, 230, 230));
            JLG_panel.setBackground(new java.awt.Color(230, 230, 230));
            JLR_panel.setBackground(new java.awt.Color(230, 230, 230));

            JK.setText("");
            JLG.setText("");
            JLR.setText("");
            J.setText("");
            K.setText("");
            HH.setText("");
            JJ.setText("");
            KK.setText("");
        } else if (j.getName() == "KMR" || j.getName() == "KML") {
            K_panel.setBackground(new java.awt.Color(230, 230, 230));
            L_panel.setBackground(new java.awt.Color(230, 230, 230));
            M_panel.setBackground(new java.awt.Color(230, 230, 230));
            KK_panel.setBackground(new java.awt.Color(230, 230, 230));
            LL_panel.setBackground(new java.awt.Color(230, 230, 230));
            KM_panel.setBackground(new java.awt.Color(230, 230, 230));
            JLG_panel.setBackground(new java.awt.Color(230, 230, 230));
            JLR_panel.setBackground(new java.awt.Color(230, 230, 230));
            LPR_panel.setBackground(new java.awt.Color(230, 230, 230));

            KM.setText("");
            JLG.setText("");
            JLR.setText("");
            LPR.setText("");
            K.setText("");
            L.setText("");
            M.setText("");
            KK.setText("");
            LL.setText("");
        } else if (j.getName() == "MPR" || j.getName() == "MPL") {
            M_panel.setBackground(new java.awt.Color(230, 230, 230));
            P_panel.setBackground(new java.awt.Color(230, 230, 230));
            LL_panel.setBackground(new java.awt.Color(230, 230, 230));
            MM_panel.setBackground(new java.awt.Color(230, 230, 230));
            MPR_panel.setBackground(new java.awt.Color(230, 230, 230));
            MPL_panel.setBackground(new java.awt.Color(230, 230, 230));
            LPR_panel.setBackground(new java.awt.Color(230, 230, 230));

            MPR.setText("");
            MPL.setText("");
            LPR.setText("");
            M.setText("");
            P.setText("");
            LL.setText("");
            MM.setText("");

        } else if (j.getName() == "PRR" || j.getName() == "PRL") {
            R_panel.setBackground(new java.awt.Color(230, 230, 230));
            P_panel.setBackground(new java.awt.Color(230, 230, 230));
            MM_panel.setBackground(new java.awt.Color(230, 230, 230));
            PP_panel.setBackground(new java.awt.Color(230, 230, 230));

            R.setText("");
            P.setText("");
            PP.setText("");
            MM.setText("");

        } else if (j.getName() == "CFG") {
            C_panel.setBackground(new java.awt.Color(230, 230, 230));
            D_panel.setBackground(new java.awt.Color(230, 230, 230));
            E_panel.setBackground(new java.awt.Color(230, 230, 230));
            F_panel.setBackground(new java.awt.Color(230, 230, 230));
            CC_panel.setBackground(new java.awt.Color(230, 230, 230));
            DD_panel.setBackground(new java.awt.Color(230, 230, 230));
            EE_panel.setBackground(new java.awt.Color(230, 230, 230));
            FF_panel.setBackground(new java.awt.Color(230, 230, 230));
            CE_panel.setBackground(new java.awt.Color(230, 230, 230));
            EF_panel.setBackground(new java.awt.Color(230, 230, 230));
            CER_panel.setBackground(new java.awt.Color(230, 230, 230));
            EFR_panel.setBackground(new java.awt.Color(230, 230, 230));
            CEL_panel.setBackground(new java.awt.Color(230, 230, 230));
            EFL_panel.setBackground(new java.awt.Color(230, 230, 230));
            CFR_panel.setBackground(new java.awt.Color(230, 230, 230));
            C.setText("");
            D.setText("");
            E.setText("");
            F.setText("");
            CC.setText("");
            DD.setText("");
            EE.setText("");
            FF.setText("");
            CE.setText("");
            EF.setText("");
            CER.setText("");
            EFR.setText("");
            CEL.setText("");
            EFL.setText("");
            CFR.setText("");

        } else if (j.getName() == "FJG") {
            F_panel.setBackground(new java.awt.Color(230, 230, 230));
            J_panel.setBackground(new java.awt.Color(230, 230, 230));
            H_panel.setBackground(new java.awt.Color(230, 230, 230));
            G_panel.setBackground(new java.awt.Color(230, 230, 230));
            FF_panel.setBackground(new java.awt.Color(230, 230, 230));
            HH_panel.setBackground(new java.awt.Color(230, 230, 230));
            GG_panel.setBackground(new java.awt.Color(230, 230, 230));
            FH_panel.setBackground(new java.awt.Color(230, 230, 230));
            HJ_panel.setBackground(new java.awt.Color(230, 230, 230));
            EF_panel.setBackground(new java.awt.Color(230, 230, 230));
            FHR_panel.setBackground(new java.awt.Color(230, 230, 230));
            HJR_panel.setBackground(new java.awt.Color(230, 230, 230));
            FHL_panel.setBackground(new java.awt.Color(230, 230, 230));
            HJL_panel.setBackground(new java.awt.Color(230, 230, 230));
            EFR_panel.setBackground(new java.awt.Color(230, 230, 230));
            EFL_panel.setBackground(new java.awt.Color(230, 230, 230));
            FJR_panel.setBackground(new java.awt.Color(230, 230, 230));
            JLR_panel.setBackground(new java.awt.Color(230, 230, 230));
            F.setText("");
            J.setText("");
            H.setText("");
            G.setText("");
            FF.setText("");
            HH.setText("");
            GG.setText("");
            FH.setText("");
            HJ.setText("");
            EF.setText("");
            FHR.setText("");
            HJR.setText("");
            FHL.setText("");
            HJL.setText("");
            EFR.setText("");
            EFL.setText("");
            FJR.setText("");
            JLR.setText("");

        } else if (j.getName() == "JLG") {
            J_panel.setBackground(new java.awt.Color(230, 230, 230));
            K_panel.setBackground(new java.awt.Color(230, 230, 230));
            L_panel.setBackground(new java.awt.Color(230, 230, 230));
            HH_panel.setBackground(new java.awt.Color(230, 230, 230));
            JJ_panel.setBackground(new java.awt.Color(230, 230, 230));
            KK_panel.setBackground(new java.awt.Color(230, 230, 230));
            LL_panel.setBackground(new java.awt.Color(230, 230, 230));
            HJ_panel.setBackground(new java.awt.Color(230, 230, 230));
            JK_panel.setBackground(new java.awt.Color(230, 230, 230));
            KM_panel.setBackground(new java.awt.Color(230, 230, 230));
            HJR_panel.setBackground(new java.awt.Color(230, 230, 230));
            JKR_panel.setBackground(new java.awt.Color(230, 230, 230));
            KMR_panel.setBackground(new java.awt.Color(230, 230, 230));
            HJL_panel.setBackground(new java.awt.Color(230, 230, 230));
            JKL_panel.setBackground(new java.awt.Color(230, 230, 230));
            KML_panel.setBackground(new java.awt.Color(230, 230, 230));
            LPR_panel.setBackground(new java.awt.Color(230, 230, 230));
            JLR_panel.setBackground(new java.awt.Color(230, 230, 230));
            J.setText("");
            K.setText("");
            L.setText("");
            HH.setText("");
            JJ.setText("");
            KK.setText("");
            LL.setText("");
            HJ.setText("");
            JK.setText("");
            KM.setText("");
            JKR.setText("");
            HJR.setText("");
            KMR.setText("");
            JKL.setText("");
            KML.setText("");
            HJL.setText("");
            JLR.setText("");
            LPR.setText("");

        } else if (j.getName() == "CFR") {
            C_panel.setBackground(new java.awt.Color(230, 230, 230));
            D_panel.setBackground(new java.awt.Color(230, 230, 230));
            E_panel.setBackground(new java.awt.Color(230, 230, 230));
            F_panel.setBackground(new java.awt.Color(230, 230, 230));
            CC_panel.setBackground(new java.awt.Color(230, 230, 230));
            DD_panel.setBackground(new java.awt.Color(230, 230, 230));
            EE_panel.setBackground(new java.awt.Color(230, 230, 230));
            CE_panel.setBackground(new java.awt.Color(230, 230, 230));
            EF_panel.setBackground(new java.awt.Color(230, 230, 230));
            CER_panel.setBackground(new java.awt.Color(230, 230, 230));
            EFR_panel.setBackground(new java.awt.Color(230, 230, 230));
            CEL_panel.setBackground(new java.awt.Color(230, 230, 230));
            EFL_panel.setBackground(new java.awt.Color(230, 230, 230));
            CFG_panel.setBackground(new java.awt.Color(230, 230, 230));
            C.setText("");
            D.setText("");
            E.setText("");
            F.setText("");
            CC.setText("");
            DD.setText("");
            EE.setText("");
            CE.setText("");
            EF.setText("");
            CER.setText("");
            EFR.setText("");
            CEL.setText("");
            EFL.setText("");
            CFG.setText("");

        } else if (j.getName() == "FJR") {
            F_panel.setBackground(new java.awt.Color(230, 230, 230));
            H_panel.setBackground(new java.awt.Color(230, 230, 230));
            G_panel.setBackground(new java.awt.Color(230, 230, 230));
            FF_panel.setBackground(new java.awt.Color(230, 230, 230));
            HH_panel.setBackground(new java.awt.Color(230, 230, 230));
            GG_panel.setBackground(new java.awt.Color(230, 230, 230));
            FH_panel.setBackground(new java.awt.Color(230, 230, 230));
            HJ_panel.setBackground(new java.awt.Color(230, 230, 230));
            EF_panel.setBackground(new java.awt.Color(230, 230, 230));
            FHR_panel.setBackground(new java.awt.Color(230, 230, 230));
            HJR_panel.setBackground(new java.awt.Color(230, 230, 230));
            FHL_panel.setBackground(new java.awt.Color(230, 230, 230));
            HJL_panel.setBackground(new java.awt.Color(230, 230, 230));
            EFR_panel.setBackground(new java.awt.Color(230, 230, 230));
            EFL_panel.setBackground(new java.awt.Color(230, 230, 230));
            FJG_panel.setBackground(new java.awt.Color(230, 230, 230));
            F.setText("");
            H.setText("");
            G.setText("");
            FF.setText("");
            HH.setText("");
            GG.setText("");
            EF.setText("");
            FH.setText("");
            HJ.setText("");
            EFR.setText("");
            FHR.setText("");
            HJR.setText("");
            EFL.setText("");
            FHL.setText("");
            HJL.setText("");
            FJG.setText("");

        } else if (j.getName() == "JLR") {
            H_panel.setBackground(new java.awt.Color(230, 230, 230));
            J_panel.setBackground(new java.awt.Color(230, 230, 230));
            K_panel.setBackground(new java.awt.Color(230, 230, 230));
            L_panel.setBackground(new java.awt.Color(230, 230, 230));
            HH_panel.setBackground(new java.awt.Color(230, 230, 230));
            JJ_panel.setBackground(new java.awt.Color(230, 230, 230));
            KK_panel.setBackground(new java.awt.Color(230, 230, 230));
            HJ_panel.setBackground(new java.awt.Color(230, 230, 230));
            JK_panel.setBackground(new java.awt.Color(230, 230, 230));
            KM_panel.setBackground(new java.awt.Color(230, 230, 230));
            HJR_panel.setBackground(new java.awt.Color(230, 230, 230));
            JKR_panel.setBackground(new java.awt.Color(230, 230, 230));
            KMR_panel.setBackground(new java.awt.Color(230, 230, 230));
            HJL_panel.setBackground(new java.awt.Color(230, 230, 230));
            JKL_panel.setBackground(new java.awt.Color(230, 230, 230));
            KML_panel.setBackground(new java.awt.Color(230, 230, 230));
            FJG_panel.setBackground(new java.awt.Color(230, 230, 230));
            JLG_panel.setBackground(new java.awt.Color(230, 230, 230));
            H.setText("");
            J.setText("");
            K.setText("");
            L.setText("");
            HH.setText("");
            JJ.setText("");
            KK.setText("");
            HJ.setText("");
            JK.setText("");
            KM.setText("");
            JKR.setText("");
            HJR.setText("");
            KMR.setText("");
            JKL.setText("");
            KML.setText("");
            HJL.setText("");
            JLG.setText("");
            FJG.setText("");

        } else if (j.getName() == "LPR") {
            L_panel.setBackground(new java.awt.Color(230, 230, 230));
            M_panel.setBackground(new java.awt.Color(230, 230, 230));
            P_panel.setBackground(new java.awt.Color(230, 230, 230));
            KK_panel.setBackground(new java.awt.Color(230, 230, 230));
            LL_panel.setBackground(new java.awt.Color(230, 230, 230));
            MM_panel.setBackground(new java.awt.Color(230, 230, 230));
            MP_panel.setBackground(new java.awt.Color(230, 230, 230));
            KM_panel.setBackground(new java.awt.Color(230, 230, 230));
            MPR_panel.setBackground(new java.awt.Color(230, 230, 230));
            KMR_panel.setBackground(new java.awt.Color(230, 230, 230));
            MPL_panel.setBackground(new java.awt.Color(230, 230, 230));
            KML_panel.setBackground(new java.awt.Color(230, 230, 230));
            JLG_panel.setBackground(new java.awt.Color(230, 230, 230));
            L.setText("");
            M.setText("");
            P.setText("");
            KK.setText("");
            LL.setText("");
            MM.setText("");
            MP.setText("");
            KM.setText("");
            MPR.setText("");
            KMR.setText("");
            MPL.setText("");
            KML.setText("");
            JLG.setText("");

        } else if (j.getName() == "T") {
            SS_panel.setBackground(new java.awt.Color(230, 230, 230));
            SS.setText("");
            deadload_update();
        }
    }

    public void random(javax.swing.JLabel j) {
        if (j.getText().equals("N")) {
            try {

                int row = deadload2.getSelectedRow();
                String Sr = (String) deadload2.getValueAt(row, 0);
                String uld = (String) deadload2.getValueAt(row, 1);
                String gross = (String) deadload2.getValueAt(row, 2);
                String tare = (String) deadload2.getValueAt(row, 4);
                String dest = (String) deadload2.getValueAt(row, 6);
                String commodity = (String) deadload2.getValueAt(row, 7);
                int Sr_No = Integer.parseInt(Sr);

                String sq_input = "update Deadload set Location = '" + j.getName() + "' where Sr = " + Sr_No + "";
                pst = con.prepareStatement(sq_input);
                pst.execute();
                j.setText("<html>" + uld + "<br>" + gross + "<br>" + tare + "<br>" + dest + " \\ " + commodity + "</html>");

                //JOptionPane.showMessageDialog(null, Sr);
                DefaultTableModel model = (DefaultTableModel) deadload2.getModel();
                deadload2.setValueAt(j.getName(), row, 9);
                j.setToolTipText(j.getText());
                deadload_update_distribution();

                //Delete Selected Row
                //     int getSelectedRowForDeletion = deadload2.getSelectedRow();
                //Check if their is a row selected
                //   if (getSelectedRowForDeletion >= 0) {
                //   model.removeRow(getSelectedRowForDeletion);
                // }
//           JOptionPane.showMessageDialog(null, j.getName());
                backgroundDistributionBlock(j);

            } catch (SQLException ex) {
                Logger.getLogger(FlightInfo.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {

        }
        /*if(!BC.getText().equals("N"))
        {
            int row = deadload2.getSelectedRow();
        String uld = (String)deadload2.getValueAt(row, 1);
        String gross = (String)deadload2.getValueAt(row, 2);
        String tare = (String)deadload2.getValueAt(row, 4);
        String dest = (String)deadload2.getValueAt(row, 6);
        String commodity = (String)deadload2.getValueAt(row, 7);
      BC.setText("<html>"+uld+"<br>"+gross+"<br>"+tare+"<br>"+dest+"<br>"+commodity+"</html>");
            
        DefaultTableModel model = (DefaultTableModel) deadload2.getModel();

        //Delete Selected Row        
        int getSelectedRowForDeletion = deadload2.getSelectedRow();
        //Check if their is a row selected
        if (getSelectedRowForDeletion >= 0) {
            model.removeRow(getSelectedRowForDeletion);
        }
         
        }*/
    }

    public void checkBoxMD1() {
        if (checkboxMD1.isSelected() == false) {
            A_panel.setVisible(false);
            B_panel.setVisible(false);
            C_panel.setVisible(false);
            D_panel.setVisible(false);
            E_panel.setVisible(false);
            F_panel.setVisible(false);
            G_panel.setVisible(false);
            H_panel.setVisible(false);
            J_panel.setVisible(false);
            K_panel.setVisible(false);
            L_panel.setVisible(false);
            M_panel.setVisible(false);
            P_panel.setVisible(false);
            R_panel.setVisible(false);
            S_panel.setVisible(false);
            T_panel.setVisible(false);
            U_panel.setVisible(false);

        }
        if (checkboxMD1.isSelected() == true) {
            A_panel.setVisible(true);
            B_panel.setVisible(true);
            C_panel.setVisible(true);
            D_panel.setVisible(true);
            E_panel.setVisible(true);
            F_panel.setVisible(true);
            G_panel.setVisible(true);
            H_panel.setVisible(true);
            J_panel.setVisible(true);
            K_panel.setVisible(true);
            L_panel.setVisible(true);
            M_panel.setVisible(true);
            P_panel.setVisible(true);
            R_panel.setVisible(true);
            S_panel.setVisible(true);
            T_panel.setVisible(true);
            U_panel.setVisible(true);

        }
    }

    public void checkBoxMD2() {
        if (checkboxMD2.isSelected() == false) {
            AA_panel.setVisible(false);
            BB_panel.setVisible(false);
            CC_panel.setVisible(false);
            DD_panel.setVisible(false);
            EE_panel.setVisible(false);
            FF_panel.setVisible(false);
            GG_panel.setVisible(false);
            HH_panel.setVisible(false);
            JJ_panel.setVisible(false);
            KK_panel.setVisible(false);
            LL_panel.setVisible(false);
            MM_panel.setVisible(false);
            PP_panel.setVisible(false);
            RR_panel.setVisible(false);
            SS_panel.setVisible(false);
            TT_panel.setVisible(false);

        }
        if (checkboxMD2.isSelected() == true) {
            AA_panel.setVisible(true);
            BB_panel.setVisible(true);
            CC_panel.setVisible(true);
            DD_panel.setVisible(true);
            EE_panel.setVisible(true);
            FF_panel.setVisible(true);
            GG_panel.setVisible(true);
            HH_panel.setVisible(true);
            JJ_panel.setVisible(true);
            KK_panel.setVisible(true);
            LL_panel.setVisible(true);
            MM_panel.setVisible(true);
            PP_panel.setVisible(true);
            RR_panel.setVisible(true);
            SS_panel.setVisible(true);
            TT_panel.setVisible(true);

        }
    }

    public void checkBoxMD3() {
        if (checkboxMD3.isSelected() == false) {
            BC_panel.setVisible(false);
            CE_panel.setVisible(false);
            EF_panel.setVisible(false);
            FH_panel.setVisible(false);
            AB_panel.setVisible(false);
            HJ_panel.setVisible(false);
            JK_panel.setVisible(false);
            KM_panel.setVisible(false);
            MP_panel.setVisible(false);

        }
        if (checkboxMD3.isSelected() == true) {
            BC_panel.setVisible(true);
            CE_panel.setVisible(true);
            EF_panel.setVisible(true);
            FH_panel.setVisible(true);
            AB_panel.setVisible(true);
            HJ_panel.setVisible(true);
            JK_panel.setVisible(true);
            KM_panel.setVisible(true);
            MP_panel.setVisible(true);

        }
    }

    public void checkBoxMD16() {
        if (checkboxMD16.isSelected() == false) {
            CFR_panel.setVisible(false);
            FJR_panel.setVisible(false);
            JLR_panel.setVisible(false);
            LPR_panel.setVisible(false);

        }
        if (checkboxMD16.isSelected() == true) {
            CFR_panel.setVisible(true);
            FJR_panel.setVisible(true);
            JLR_panel.setVisible(true);
            LPR_panel.setVisible(true);

        }
    }

    public void checkBoxMD20() {

        if (checkboxMD20.isSelected() == false) {
            CFG_panel.setVisible(false);
            FJG_panel.setVisible(false);
            JLG_panel.setVisible(false);

        }
        if (checkboxMD20.isSelected() == true) {
            CFG_panel.setVisible(true);
            FJG_panel.setVisible(true);
            JLG_panel.setVisible(true);

        }
    }

    public void MD1(int x) {

        A.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255), x));
        B.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255), x));
        C.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255), x));
        D.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255), x));
        E.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255), x));
        F.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255), x));
        G.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255), x));
        H.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255), x));
        J.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255), x));
        K.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255), x));
        L.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255), x));
        M.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255), x));
        P.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255), x));
        R.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255), x));
        S.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255), x));
        T.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255), x));
        U.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255), x));

    }

    public void MD2(int x) {

        AA.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0), x));
        BB.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0), x));
        CC.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0), x));
        DD.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0), x));
        EE.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0), x));
        FF.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0), x));
        GG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0), x));
        HH.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0), x));
        JJ.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0), x));
        KK.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0), x));
        LL.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0), x));
        MM.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0), x));
        PP.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0), x));
        RR.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0), x));
        SS.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0), x));
        TT.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0), x));

    }

    public void MD3(int x) {
        AB.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 204, 0), x));
        BC.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 204, 0), x));
        CE.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 204, 0), x));
        EF.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 204, 0), x));
        FH.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 204, 0), x));
        HJ.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 204, 0), x));
        JK.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 204, 0), x));
        KM.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 204, 0), x));
        MP.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 204, 0), x));

    }

    public void MD4(int x) {

        ABR.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 0), x));
        BCR.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 0), x));
        CER.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 0), x));
        EFR.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 0), x));
        FHR.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 0), x));
        HJR.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 0), x));
        JKR.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 0), x));
        KMR.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 0), x));
        MPR.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 0), x));
        PRR.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 0), x));
        ABL.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 0), x));
        BCL.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 0), x));
        CEL.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 0), x));
        EFL.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 0), x));
        FHL.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 0), x));
        HJL.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 0), x));
        JKL.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 0), x));
        KML.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 0), x));
        MPL.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 0), x));
        PRL.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 0), x));

    }

    public void MD41(int x) {

    }

    public void MD16(int x) {

        CFR.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(86, 36, 36), x));
        FJR.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(86, 36, 36), x));
        JLR.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(86, 36, 36), x));
        LPR.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(86, 36, 36), x));

    }

    public void MD20(int x) {
        CFG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 0, 102), x));
        FJG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 0, 102), x));
        JLG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 0, 102), x));

    }

    public void LD1() {

    }

    public void LD2() {

    }

    public void LD3() {

    }

    public void switchPanels1(JScrollPane pane) {
        jLayeredPane1.removeAll();
        jLayeredPane1.add(pane);
        jLayeredPane1.repaint();
        jLayeredPane1.revalidate();
    }

    public void switchPanels(JPanel panel) {
        jLayeredPane1.removeAll();
        jLayeredPane1.add(panel);
        jLayeredPane1.repaint();
        jLayeredPane1.revalidate();
    }

    public void displayPublication() {

        try {
            con = Connect.ConnectDB();
            String sql = "SELECT * FROM publication";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()) {

                int m_mto = rs.getInt("max taxi out");

                int m_tow = rs.getInt("max takeoff weight");
                int m_ldw = rs.getInt("max landing weight");
                int m_zfw = rs.getInt("max zfw");
                int m_mw = rs.getInt("minimum weight");
                p_tow.setText(Integer.toString(m_tow));
                p_ldw.setText(Integer.toString(m_ldw));
                p_zfw.setText(Integer.toString(m_zfw));

            }

        } catch (SQLException ex) {
            Logger.getLogger(FlightInfo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void displayFuelInfo() {

        try {
            con = Connect.ConnectDB();
            String sql = "SELECT * FROM newFlight where Active ='yes'";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()) {
                String FLT = rs.getString("FLT_NO");
                pst = null;
                rs = null;
                String sq2 = "SELECT * FROM fuelInfo where FLT_NO ='" + FLT + "'";
                pst = con.prepareStatement(sq2);
                rs = pst.executeQuery();

                if (rs.next()) {
                    int bf = rs.getInt("block_fuel");

                    String bfi = rs.getString("block_fuel_index");
                    int tf = rs.getInt("trip_fuel");
                    String tfi = rs.getString("trip_fuel_index");
                    int uf = rs.getInt("unusable_fuel");
                    String ufi = rs.getString("unusable_fuel_index");
                    int txf = rs.getInt("taxi_fuel");

                    w_taxi.setText(Integer.toString(txf));
                    w_f_board.setText(Integer.toString(bf));
                    i_f_board.setText(bfi);
                    w_trip.setText(Integer.toString(tf));
                    i_trip.setText(tfi);
                    w_unusable.setText(Integer.toString(uf));
                    i_unusable.setText(ufi);
                }
            } else {

                w_taxi.setText("");
                w_f_board.setText("");
                i_f_board.setText("");
                w_trip.setText("");
                i_trip.setText("");
                w_unusable.setText("");
                i_unusable.setText("");
            }
        } catch (SQLException ex) {
            Logger.getLogger(FlightInfo.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void resetMainDeck() {
        A.setText("N");
        B.setText("N");
        C.setText("N");
        D.setText("N");
        E.setText("N");
        F.setText("N");
        G.setText("N");
        H.setText("N");
        J.setText("N");
        K.setText("N");
        L.setText("N");
        M.setText("N");
        P.setText("N");
        R.setText("N");
        S.setText("N");
        T.setText("N");
        U.setText("N");

        AA.setText("N");
        BB.setText("N");
        CC.setText("N");
        DD.setText("N");
        EE.setText("N");
        FF.setText("N");
        GG.setText("N");
        HH.setText("N");
        JJ.setText("N");
        KK.setText("N");
        LL.setText("N");
        MM.setText("N");
        PP.setText("N");
        RR.setText("N");
        SS.setText("N");
        TT.setText("N");

        AB.setText("N");
        BC.setText("N");
        CE.setText("N");
        EF.setText("N");
        FH.setText("N");
        HJ.setText("N");
        JK.setText("N");
        KM.setText("N");
        MP.setText("N");

        ABR.setText("N");
        BCR.setText("N");
        CER.setText("N");
        EFR.setText("N");
        FHR.setText("N");
        HJR.setText("N");
        JKR.setText("N");
        KMR.setText("N");
        MPR.setText("N");
        PRR.setText("N");

        ABL.setText("N");
        BCL.setText("N");
        CEL.setText("N");
        EFL.setText("N");
        FHL.setText("N");
        HJL.setText("N");
        JKL.setText("N");
        KML.setText("N");
        MPL.setText("N");

        CFG.setText("N");
        FJG.setText("N");
        JLG.setText("N");
        CFR.setText("N");
        FJR.setText("N");
        JLR.setText("N");
        LPR.setText("N");

    }

    public void resetFlightCreatorFields() {
        f_date.setDate(null);
        f_flight_no.setText("");
        f_std.setText("");
        f_dest1.setText("");
        f_dest2.setText("");
        f_dest3.setText("");
        f_org.setText("");
        f_reg.setSelectedIndex(0);
        f_ac.setSelectedIndex(0);
        title.setText("Flight Info");
        switchPanels(flightInfoPanel);
    }

    public void showInfoFlightData() {//TO VIEW THE DATA OF FLIGHT INFO TAB

        String sqla = "SELECT DISTINCT REGISTRATIONS FROM [CREW CORRECTION]";
        String sqlb = "SELECT DISTINCT CREW FROM [CREW CORRECTION]";

        try {
            con = Connect.ConnectDB();
            pst = con.prepareStatement(sqla);
            rs = pst.executeQuery();

            while (rs.next()) {
                regCombo.addItem(rs.getString("REGISTRATIONS"));

            }
            pst = null;
            rs = null;
            pst = con.prepareStatement(sqlb);
            rs = pst.executeQuery();

            while (rs.next()) {
                crewCombo.addItem(rs.getString("CREW"));

            }

            String sql = "SELECT * FROM newFlight where Active = 'yes'";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            String flt = null;
            if (rs.next()) {
                String f = rs.getString("FLT_NO");
                flt = f;
            }
            String sql3 = "SELECT * FROM [WEIGHT CORRECTION] where FLT_NO ='" + flt + "'";
            pst = con.prepareStatement(sql3);
            rs = pst.executeQuery();
            if (rs.next()) {
                regCombo.setSelectedItem(rs.getString("REGISTRATION"));
                crewCombo.setSelectedItem(rs.getString("CREW"));
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void flightInfo_Update() { //TO RETRIVE DATA FROM DATABASE OF  ACTIVE FLIGHT
        try {
            con = Connect.ConnectDB();
            String sql = "SELECT * FROM newFlight where Active = 'yes'";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            String flt = null;
            if (rs.next()) {
                String r = rs.getString("REG");

                String f = rs.getString("FLT_NO");
                flt = f;
                String ac = rs.getString("AC_TYPE");
                String s = rs.getString("STA");
                String dt = rs.getString("Date");
                String o = rs.getString("ORG");
                String d = rs.getString("DEST1");
                String d2 = rs.getString("DEST2");
                String d3 = rs.getString("DEST3");
                if (d2.isEmpty() == false) {
                    d = "" + d + "-" + d2 + "";
                    if (d3.isEmpty() == false) {
                        d = "" + d + "-" + d3 + "";
                    }
                }

                String rgs = (String) regCombo.getSelectedItem();
                String c = (String) crewCombo.getSelectedItem();

                if (list1.getText().equals("")) {
                    flight1 = f;
                    list1.setText("<html> " + f + " <br> " + dt + " <br> " + o + "-" + d + " </html>");
                    check1.setVisible(true);
                    check1.setText("<html> " + f + " " + dt + " " + o + "-" + d + " </html>");
                    list1.setBackground(new Color(255, 102, 0));

                    ac_type.setText(ac);
                    route.setText("" + o + "-" + d + "");
                    date.setText(dt);
                    std.setText(s);

                    String sq2 = "SELECT * FROM [CREW CORRECTION] where  REGISTRATIONS= '" + rgs + "' and CREW = '" + c + "'";
                    pst = con.prepareStatement(sq2);
                    rs = pst.executeQuery();
                    while (rs.next()) {
                        int dw = rs.getInt("DOW");
                        String di = rs.getString("DOI");

                        String sq3 = "update [WEIGHT CORRECTION] set CREW = '" + c + "',REGISTRATION =  '" + rgs + "', DOW = '" + dw + "', DOI = '" + di + "' where FLT_NO = '" + flight1 + "'";
                        pst = con.prepareStatement(sq3);
                        pst.execute();

                    }

                    setDOW_I();

                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(FlightInfo.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void update() {//left side view the list of all flight except active

        try {
            con = Connect.ConnectDB();
            String sql = "SELECT * FROM newFlight where Active ='no'";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {

                String f = rs.getString("FLT_NO");
                String dt = rs.getString("Date");
                String o = rs.getString("ORG");
                String d = rs.getString("DEST1");
                String d2 = rs.getString("DEST2");
                String d3 = rs.getString("DEST3");
                if (d2.isEmpty() == false) {
                    d = "" + d + "-" + d2 + "";
                    if (d3.isEmpty() == false) {
                        d = "" + d + "-" + d3 + "";
                    }
                }
                if (list1.getText().equals("")) {
                    flight1 = f;
                    list1.setText("<html> " + f + " <br> " + dt + " <br> " + o + "-" + d + " </html>");
                    check1.setVisible(true);
                    check1.setText("<html> " + f + " " + dt + " " + o + "-" + d + " </html>");
                    list1.setBackground(new Color(76, 80, 82));
                } else if (list2.getText().equals("")) {
                    flight2 = f;
                    list2.setText("<html> " + f + " <br> " + dt + " <br> " + o + "-" + d + " </html>");
                    check2.setVisible(true);
                    check2.setText("<html> " + f + " " + dt + " " + o + "-" + d + " </html>");
                    list2.setBackground(new Color(76, 80, 82));
                } else if (list3.getText().equals("")) {
                    flight3 = f;
                    list3.setText("<html> " + f + " <br> " + dt + " <br> " + o + "-" + d + " </html>");
                    check3.setVisible(true);
                    check3.setText("<html> " + f + " " + dt + " " + o + "-" + d + " </html>");
                    list3.setBackground(new Color(76, 80, 82));
                } else if (list4.getText().equals("")) {
                    flight4 = f;
                    list4.setText("<html> " + f + " <br> " + dt + " <br> " + o + "-" + d + " </html>");
                    check4.setVisible(true);
                    check4.setText("<html> " + f + " " + dt + " " + o + "-" + d + " </html>");
                    list4.setBackground(new Color(76, 80, 82));
                } else if (list5.getText().equals("")) {
                    flight5 = f;
                    list5.setText("<html> " + f + " <br> " + dt + " <br> " + o + "-" + d + " </html>");
                    check5.setVisible(true);
                    check5.setText("<html> " + f + " " + dt + " " + o + "-" + d + " </html>");
                    list5.setBackground(new Color(76, 80, 82));
                } else if (list6.getText().equals("")) {
                    flight6 = f;
                    list6.setText("<html> " + f + " <br> " + dt + " <br> " + o + "-" + d + " </html>");
                    check6.setVisible(true);
                    check6.setText("<html> " + f + " " + dt + " " + o + "-" + d + " </html>");
                    list6.setBackground(new Color(76, 80, 82));
                } else if (list7.getText().equals("")) {
                    flight7 = f;
                    list7.setText("<html> " + f + " <br> " + dt + " <br> " + o + "-" + d + " </html>");
                    check7.setVisible(true);
                    check7.setText("<html> " + f + " " + dt + " " + o + "-" + d + " </html>");
                    list7.setBackground(new Color(76, 80, 82));
                } else if (list8.getText().equals("")) {
                    flight8 = f;
                    list8.setText("<html> " + f + " <br> " + dt + " <br> " + o + "-" + d + " </html>");
                    check8.setVisible(true);
                    check8.setText("<html> " + f + " " + dt + " " + o + "-" + d + " </html>");
                    list8.setBackground(new Color(76, 80, 82));
                } else if (list9.getText().equals("")) {
                    flight9 = f;
                    list9.setText("<html> " + f + " <br> " + dt + " <br> " + o + "-" + d + " </html>");
                    check9.setVisible(true);
                    check9.setText("<html> " + f + " " + dt + " " + o + "-" + d + " </html>");
                    list9.setBackground(new Color(76, 80, 82));
                } else if (list10.getText().equals("")) {
                    flight10 = f;
                    list10.setText("<html> " + f + " <br> " + dt + " <br> " + o + "-" + d + " </html>");
                    check10.setVisible(true);
                    check10.setText("<html> " + f + " " + dt + " " + o + "-" + d + " </html>");
                    list10.setBackground(new Color(76, 80, 82));
                } else if (list11.getText().equals("")) {
                    flight11 = f;
                    list11.setText("<html> " + f + " <br> " + dt + " <br> " + o + "-" + d + " </html>");
                    check1.setVisible(true);
                    check11.setText("<html> " + f + " " + dt + " " + o + "-" + d + " </html>");
                    list11.setBackground(new Color(76, 80, 82));
                } else if (list12.getText().equals("")) {

                    flight12 = f;
                    list12.setText("<html> " + f + " <br> " + dt + " <br> " + o + "-" + d + " </html>");
                    check12.setVisible(true);
                    check12.setText("<html> " + f + " " + dt + " " + o + "-" + d + " </html>");
                    list12.setBackground(new Color(76, 80, 82));
                } else if (list13.getText().equals("")) {
                    flight13 = f;
                    list13.setText("<html> " + f + " <br> " + dt + " <br> " + o + "-" + d + " </html>");

                    check13.setVisible(true);
                    check13.setText("<html> " + f + " " + dt + " " + o + "-" + d + " </html>");
                    list13.setBackground(new Color(76, 80, 82));
                } else if (list14.getText().equals("")) {
                    flight14 = f;
                    list14.setText("<html> " + f + " <br> " + dt + " <br> " + o + "-" + d + " </html>");
                    check14.setVisible(true);
                    check14.setText("<html> " + f + " " + dt + " " + o + "-" + d + " </html>");
                    list14.setBackground(new Color(76, 80, 82));
                } else if (list15.getText().equals("")) {
                    flight15 = f;
                    list15.setText("<html> " + f + " <br> " + dt + " <br> " + o + "-" + d + " </html>");

                    check15.setVisible(true);
                    check15.setText("<html> " + f + " " + dt + " " + o + "-" + d + " </html>");
                    list15.setBackground(new Color(76, 80, 82));
                } else if (list16.getText().equals("")) {
                    flight16 = f;
                    list16.setText("<html> " + f + " <br> " + dt + " <br> " + o + "-" + d + " </html>");
                    check16.setVisible(true);
                    check16.setText("<html> " + f + " " + dt + " " + o + "-" + d + " </html>");
                    list16.setBackground(new Color(76, 80, 82));
                } else if (list17.getText().equals("")) {
                    flight17 = f;
                    list17.setText("<html> " + f + " <br> " + dt + " <br> " + o + "-" + d + " </html>");
                    check17.setVisible(true);
                    check17.setText("<html> " + f + " " + dt + " " + o + "-" + d + " </html>");
                    list17.setBackground(new Color(76, 80, 82));
                } else if (list18.getText().equals("")) {
                    flight18 = f;
                    list18.setText("<html> " + f + " <br> " + dt + " <br> " + o + "-" + d + " </html>");

                    check18.setVisible(true);
                    check18.setText("<html> " + f + " " + dt + " " + o + "-" + d + " </html>");
                    list18.setBackground(new Color(76, 80, 82));
                } else if (list19.getText().equals("")) {
                    flight19 = f;
                    list19.setText("<html> " + f + " <br> " + dt + " <br> " + o + "-" + d + " </html>");

                    check19.setVisible(true);
                    check19.setText("<html> " + f + " " + dt + " " + o + "-" + d + " </html>");
                    list19.setBackground(new Color(76, 80, 82));
                } else if (list20.getText().equals("")) {
                    flight20 = f;
                    list20.setText("<html> " + f + " <br> " + dt + " <br> " + o + "-" + d + " </html>");
                    check20.setVisible(true);
                    check20.setText("<html> " + f + " " + dt + " " + o + "-" + d + " </html>");

                    list20.setBackground(new Color(76, 80, 82));
                } else if (list21.getText().equals("")) {
                    flight21 = f;
                    list21.setText("<html> " + f + " <br> " + dt + " <br> " + o + "-" + d + " </html>");

                    check21.setVisible(true);
                    check21.setText("<html> " + f + " " + dt + " " + o + "-" + d + " </html>");
                    list21.setBackground(new Color(76, 80, 82));
                } else if (list22.getText().equals("")) {
                    flight22 = f;
                    list22.setText("<html> " + f + " <br> " + dt + " <br> " + o + "-" + d + " </html>");
                    check22.setVisible(true);
                    check22.setText("<html> " + f + " " + dt + " " + o + "-" + d + " </html>");
                    list22.setBackground(new Color(76, 80, 82));
                } else if (list23.getText().equals("")) {
                    flight23 = f;
                    list23.setText("<html> " + f + " <br> " + dt + " <br> " + o + "-" + d + " </html>");
                    check23.setVisible(true);
                    check23.setText("<html> " + f + " " + dt + " " + o + "-" + d + " </html>");
                    list23.setBackground(new Color(76, 80, 82));
                } else if (list24.getText().equals("")) {
                    flight24 = f;
                    list24.setText("<html> " + f + " <br> " + dt + " <br> " + o + "-" + d + " </html>");
                    check24.setVisible(true);
                    check24.setText("<html> " + f + " " + dt + " " + o + "-" + d + " </html>");
                    list24.setBackground(new Color(76, 80, 82));
                } else if (list25.getText().equals("")) {
                    flight25 = f;
                    list25.setText("<html> " + f + " <br> " + dt + " <br> " + o + "-" + d + " </html>");
                    check25.setVisible(true);
                    check25.setText("<html> " + f + " " + dt + " " + o + "-" + d + " </html>");
                    list25.setBackground(new Color(76, 80, 82));
                    checkList = 1;
                }

            }
        } catch (SQLException ex) {
            Logger.getLogger(FlightInfo.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void setDOW_I() {
        try {
            String sq6 = "SELECT * FROM newFlight where  Active = 'yes'";
            pst = con.prepareStatement(sq6);
            rs = pst.executeQuery();

            int i = 0;
            while (rs.next()) {
                i++;
            }
            if (i == 0) {
                return;
            }

            String sq4 = "SELECT * FROM [WEIGHT CORRECTION] where  FLT_NO = '" + flight1 + "'";
            pst = con.prepareStatement(sq4);
            rs = pst.executeQuery();
            int dw = 0;
            String di = "";
            while (rs.next()) {
                dw = rs.getInt("DOW");
                di = rs.getString("DOI");
            }

            dow.setText(Integer.toString(dw));
            doi.setText(di);
        } catch (SQLException ex) {
            Logger.getLogger(FlightInfo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void pressExitDrag(javax.swing.JLabel lable, String type) {
        if (!lable.getText().equals("N")) {
            lable.setTransferHandler(new TransferHandler(type));
            MouseListener listener = new MouseAdapter() {
                public void mousePressed(MouseEvent me) {
                    JComponent comp = (JComponent) me.getSource();
                    TransferHandler handler = comp.getTransferHandler();
                    handler.exportAsDrag(comp, me, TransferHandler.COPY);
                }
            };
            lable.addMouseListener(listener);
        }

    }

    public void drag(javax.swing.JLabel lable) {
        if (lable.getText().equals("N")) {
            lable.setTransferHandler(new TransferHandler("text"));
            MouseListener listener = new MouseAdapter() {
                public void mousePressed(MouseEvent me) {
                    JComponent comp = (JComponent) me.getSource();
                    TransferHandler handler = comp.getTransferHandler();
                    handler.exportAsDrag(comp, me, TransferHandler.COPY);
                }
            };
            lable.addMouseListener(listener);
        } else {
            lable.setTransferHandler(new TransferHandler("abc"));
            MouseListener listener = new MouseAdapter() {
                public void mousePressed(MouseEvent me) {
                    JComponent comp = (JComponent) me.getSource();
                    TransferHandler handler = comp.getTransferHandler();
                    handler.exportAsDrag(comp, me, TransferHandler.COPY);
                }
            };
            lable.addMouseListener(listener);

        }
    }

    public void drag1(javax.swing.JLabel lable) {
        if (lable.getText().equals("N")) {

            lable.setTransferHandler(new TransferHandler("abc"));
            MouseListener listener = new MouseAdapter() {
                public void mousePressed(MouseEvent me) {
                    JComponent comp = (JComponent) me.getSource();
                    TransferHandler handler = comp.getTransferHandler();
                    handler.exportAsDrag(comp, me, TransferHandler.COPY);
                }
            };
            lable.addMouseListener(listener);
        }
    }

    public void dragApply() {
        drag(CFG);
        drag(FJG);
        drag(JLG);
        drag(CFG);
        drag(CFR);
        drag(FJR);
        drag(JLR);
        drag(LPR);
        drag(AB);
        drag(BC);
        drag(CE);
        drag(EF);
        drag(FH);
        drag(HJ);
        drag(JK);
        drag(KM);
        drag(MP);
        drag(A);
        drag(B);
        drag(C);
        drag(D);
        drag(E);
        drag(F);
        drag(G);
        drag(H);
        drag(J);
        drag(K);
        drag(L);
        drag(M);
        drag(P);
        drag(R);
        drag(S);
        drag(T);
        drag(U);
        drag(AA);
        drag(BB);
        drag(CC);
        drag(DD);
        drag(EE);
        drag(FF);
        drag(GG);
        drag(HH);
        drag(JJ);
        drag(KK);
        drag(LL);
        drag(MM);
        drag(PP);
        drag(RR);
        drag(SS);
        drag(TT);

        drag(ABR);
        drag(BCR);
        drag(CER);
        drag(EFR);
        drag(FHR);
        drag(HJR);
        drag(JKR);
        drag(KMR);
        drag(MPR);
        drag(PRR);

        drag(ABL);
        drag(BCL);
        drag(CEL);
        drag(EFL);
        drag(FHL);
        drag(HJL);
        drag(JKL);
        drag(KML);
        drag(MPL);
        drag(PRL);
//      if ((CFG.getText().equals("N"))) {
//            CFG.setTransferHandler(new TransferHandler("text"));
//            MouseListener listenerCFG1 = new MouseAdapter() {
//                public void mousePressed(MouseEvent me) {
//                    JComponent comp = (JComponent) me.getSource();
//                    TransferHandler handler = comp.getTransferHandler();
//                    handler.exportAsDrag(comp, me, TransferHandler.COPY);
//                }
//            };
//
//            CFG.addMouseListener(listenerCFG1);
//
//        } else {
//            CFG.setTransferHandler(new TransferHandler("abc"));
//            MouseListener listenerCFG1 = new MouseAdapter() {
//                public void mousePressed(MouseEvent me) {
//                    JComponent comp = (JComponent) me.getSource();
//                    TransferHandler handler = comp.getTransferHandler();
//                    handler.exportAsDrag(comp, me, TransferHandler.COPY);
//                }
//            };
//
//            CFG.addMouseListener(listenerCFG1);
//        }
//        if ((FJG.getText().equals("N"))) {
//
//            FJG.setTransferHandler(new TransferHandler("text"));
//            MouseListener listenerFJG1 = new MouseAdapter() {
//                public void mousePressed(MouseEvent me) {
//                    JComponent comp = (JComponent) me.getSource();
//                    TransferHandler handler = comp.getTransferHandler();
//                    handler.exportAsDrag(comp, me, TransferHandler.COPY);
//                }
//            };
//
//            FJG.addMouseListener(listenerFJG1);
//
//        } else {
//
//            FJG.setTransferHandler(new TransferHandler("abc"));
//            MouseListener listenerFJG1 = new MouseAdapter() {
//                public void mousePressed(MouseEvent me) {
//                    JComponent comp = (JComponent) me.getSource();
//                    TransferHandler handler = comp.getTransferHandler();
//                    handler.exportAsDrag(comp, me, TransferHandler.COPY);
//                }
//            };
//            FJG.addMouseListener(listenerFJG1);
//
//        }
//
//        if ((JLG.getText().equals("N"))) {
//
//            JLG.setTransferHandler(new TransferHandler("text"));
//            MouseListener listenerJLG1 = new MouseAdapter() {
//                public void mousePressed(MouseEvent me) {
//                    JComponent comp = (JComponent) me.getSource();
//                    TransferHandler handler = comp.getTransferHandler();
//                    handler.exportAsDrag(comp, me, TransferHandler.COPY);
//                }
//            };
//            JLG.addMouseListener(listenerJLG1);
//
//        } else {
//            JLG.setTransferHandler(new TransferHandler("text"));
//            MouseListener listenerJLG1 = new MouseAdapter() {
//                public void mousePressed(MouseEvent me) {
//                    JComponent comp = (JComponent) me.getSource();
//                    TransferHandler handler = comp.getTransferHandler();
//                    handler.exportAsDrag(comp, me, TransferHandler.COPY);
//                }
//            };
//            JLG.addMouseListener(listenerJLG1);
//
//        }
//        if (AB.getText().equals("N")) {
//            AB.setTransferHandler(new TransferHandler("text"));
//            MouseListener listenerAB1 = new MouseAdapter() {
//                public void mousePressed(MouseEvent me) {
//                    JComponent comp = (JComponent) me.getSource();
//                    TransferHandler handler = comp.getTransferHandler();
//                    handler.exportAsDrag(comp, me, TransferHandler.COPY);
//                }
//            };
//            AB.addMouseListener(listenerAB1);
//
//        } else {
//
//            AB.setTransferHandler(new TransferHandler("abc"));
//            MouseListener listenerAB1 = new MouseAdapter() {
//                public void mousePressed(MouseEvent me) {
//                    JComponent comp = (JComponent) me.getSource();
//                    TransferHandler handler = comp.getTransferHandler();
//                    handler.exportAsDrag(comp, me, TransferHandler.COPY);
//                }
//            };
//            AB.addMouseListener(listenerAB1);
//        }
//        if (BC.getText().equals("N")) {
//            BC.setTransferHandler(new TransferHandler("text"));
//            MouseListener listenerBC1 = new MouseAdapter() {
//                public void mousePressed(MouseEvent me) {
//                    JComponent comp = (JComponent) me.getSource();
//                    TransferHandler handler = comp.getTransferHandler();
//                    handler.exportAsDrag(comp, me, TransferHandler.COPY);
//                }
//            };
//            BC.addMouseListener(listenerBC1);
//
//        } else {
//            BC.setTransferHandler(new TransferHandler("abc"));
//            MouseListener listenerBC1 = new MouseAdapter() {
//                public void mousePressed(MouseEvent me) {
//                    JComponent comp = (JComponent) me.getSource();
//                    TransferHandler handler = comp.getTransferHandler();
//                    handler.exportAsDrag(comp, me, TransferHandler.COPY);
//                }
//            };
//            BC.addMouseListener(listenerBC1);
//
//        }
//
//        if (CE.getText().equals("N")) {
//            CE.setTransferHandler(new TransferHandler("text"));
//            MouseListener listenerCE1 = new MouseAdapter() {
//                public void mousePressed(MouseEvent me) {
//                    JComponent comp = (JComponent) me.getSource();
//                    TransferHandler handler = comp.getTransferHandler();
//                    handler.exportAsDrag(comp, me, TransferHandler.COPY);
//                }
//            };
//            CE.addMouseListener(listenerCE1);
//
//        } else {
//            CE.setTransferHandler(new TransferHandler("abc"));
//            MouseListener listenerCE1 = new MouseAdapter() {
//                public void mousePressed(MouseEvent me) {
//                    JComponent comp = (JComponent) me.getSource();
//                    TransferHandler handler = comp.getTransferHandler();
//                    handler.exportAsDrag(comp, me, TransferHandler.COPY);
//                }
//            };
//            CE.addMouseListener(listenerCE1);
//
//        }
//
//        if ((EF.getText().equals("N"))) {
//            EF.setTransferHandler(new TransferHandler("text"));
//            MouseListener listenerEF1 = new MouseAdapter() {
//                public void mousePressed(MouseEvent me) {
//                    JComponent comp = (JComponent) me.getSource();
//                    TransferHandler handler = comp.getTransferHandler();
//                    handler.exportAsDrag(comp, me, TransferHandler.COPY);
//                }
//            };
//            EF.addMouseListener(listenerEF1);
//
//        } else {
//            EF.setTransferHandler(new TransferHandler("abc"));
//            MouseListener listenerEF1 = new MouseAdapter() {
//                public void mousePressed(MouseEvent me) {
//                    JComponent comp = (JComponent) me.getSource();
//                    TransferHandler handler = comp.getTransferHandler();
//                    handler.exportAsDrag(comp, me, TransferHandler.COPY);
//                }
//            };
//            EF.addMouseListener(listenerEF1);
//
//        }
//        if ((FH.getText().equals("N"))) {
//            FH.setTransferHandler(new TransferHandler("text"));
//            MouseListener listenerFH1 = new MouseAdapter() {
//                public void mousePressed(MouseEvent me) {
//                    JComponent comp = (JComponent) me.getSource();
//                    TransferHandler handler = comp.getTransferHandler();
//                    handler.exportAsDrag(comp, me, TransferHandler.COPY);
//                }
//            };
//            FH.addMouseListener(listenerFH1);
//
//        } else {
//            FH.setTransferHandler(new TransferHandler("abc"));
//            MouseListener listenerFH1 = new MouseAdapter() {
//                public void mousePressed(MouseEvent me) {
//                    JComponent comp = (JComponent) me.getSource();
//                    TransferHandler handler = comp.getTransferHandler();
//                    handler.exportAsDrag(comp, me, TransferHandler.COPY);
//                }
//            };
//            FH.addMouseListener(listenerFH1);
//
//        }
//
//        if ((HJ.getText().equals("N"))) {
//
//            HJ.setTransferHandler(new TransferHandler("text"));
//            MouseListener listenerHJ1 = new MouseAdapter() {
//                public void mousePressed(MouseEvent me) {
//                    JComponent comp = (JComponent) me.getSource();
//                    TransferHandler handler = comp.getTransferHandler();
//                    handler.exportAsDrag(comp, me, TransferHandler.COPY);
//                }
//            };
//            HJ.addMouseListener(listenerHJ1);
//
//        } else {
//            HJ.setTransferHandler(new TransferHandler("abc"));
//            MouseListener listenerHJ1 = new MouseAdapter() {
//                public void mousePressed(MouseEvent me) {
//                    JComponent comp = (JComponent) me.getSource();
//                    TransferHandler handler = comp.getTransferHandler();
//                    handler.exportAsDrag(comp, me, TransferHandler.COPY);
//                }
//            };
//            HJ.addMouseListener(listenerHJ1);
//
//        }
//
//        if ((A.getText().equals("N"))) {
//
//            A.setTransferHandler(new TransferHandler("text"));
//            MouseListener listenerA1 = new MouseAdapter() {
//                public void mousePressed(MouseEvent me) {
//                    JComponent comp = (JComponent) me.getSource();
//                    TransferHandler handler = comp.getTransferHandler();
//                    handler.exportAsDrag(comp, me, TransferHandler.COPY);
//                }
//            };
//            A.addMouseListener(listenerA1);
//
//        } else {
//            A.setTransferHandler(new TransferHandler("abc"));
//            MouseListener listenerA1 = new MouseAdapter() {
//                public void mousePressed(MouseEvent me) {
//                    JComponent comp = (JComponent) me.getSource();
//                    TransferHandler handler = comp.getTransferHandler();
//                    handler.exportAsDrag(comp, me, TransferHandler.COPY);
//                }
//            };
//            A.addMouseListener(listenerA1);
//
//        }
//
//        if ((B.getText().equals("N"))) {
//
//            B.setTransferHandler(new TransferHandler("text"));
//            MouseListener listenerB1 = new MouseAdapter() {
//                public void mousePressed(MouseEvent me) {
//                    JComponent comp = (JComponent) me.getSource();
//                    TransferHandler handler = comp.getTransferHandler();
//                    handler.exportAsDrag(comp, me, TransferHandler.COPY);
//                }
//            };
//            B.addMouseListener(listenerB1);
//
//        } else {
//            B.setTransferHandler(new TransferHandler("abc"));
//            MouseListener listenerB1 = new MouseAdapter() {
//                public void mousePressed(MouseEvent me) {
//                    JComponent comp = (JComponent) me.getSource();
//                    TransferHandler handler = comp.getTransferHandler();
//                    handler.exportAsDrag(comp, me, TransferHandler.COPY);
//                }
//            };
//            B.addMouseListener(listenerB1);
//
//        }
//
//        if ((C.getText().equals("N"))) {
//
//            C.setTransferHandler(new TransferHandler("text"));
//            MouseListener listenerC1 = new MouseAdapter() {
//                public void mousePressed(MouseEvent me) {
//                    JComponent comp = (JComponent) me.getSource();
//                    TransferHandler handler = comp.getTransferHandler();
//                    handler.exportAsDrag(comp, me, TransferHandler.COPY);
//                }
//            };
//            C.addMouseListener(listenerC1);
//
//        } else {
//            C.setTransferHandler(new TransferHandler("abc"));
//            MouseListener listenerC1 = new MouseAdapter() {
//                public void mousePressed(MouseEvent me) {
//                    JComponent comp = (JComponent) me.getSource();
//                    TransferHandler handler = comp.getTransferHandler();
//                    handler.exportAsDrag(comp, me, TransferHandler.COPY);
//                }
//            };
//            C.addMouseListener(listenerC1);
//
//        }
//
//        D.setTransferHandler(new TransferHandler("text"));
//        MouseListener listenerD1 = new MouseAdapter() {
//            public void mousePressed(MouseEvent me) {
//                JComponent comp = (JComponent) me.getSource();
//                TransferHandler handler = comp.getTransferHandler();
//                handler.exportAsDrag(comp, me, TransferHandler.COPY);
//            }
//        };
//        D.addMouseListener(listenerD1);
//
//        E.setTransferHandler(new TransferHandler("text"));
//        MouseListener listenerE1 = new MouseAdapter() {
//            public void mousePressed(MouseEvent me) {
//                JComponent comp = (JComponent) me.getSource();
//                TransferHandler handler = comp.getTransferHandler();
//                handler.exportAsDrag(comp, me, TransferHandler.COPY);
//            }
//        };
//        E.addMouseListener(listenerE1);
//
//        F.setTransferHandler(new TransferHandler("text"));
//        MouseListener listenerF1 = new MouseAdapter() {
//            public void mousePressed(MouseEvent me) {
//                JComponent comp = (JComponent) me.getSource();
//                TransferHandler handler = comp.getTransferHandler();
//                handler.exportAsDrag(comp, me, TransferHandler.COPY);
//            }
//        };
//        F.addMouseListener(listenerF1);
//
//        G.setTransferHandler(new TransferHandler("text"));
//        MouseListener listenerG1 = new MouseAdapter() {
//            public void mousePressed(MouseEvent me) {
//                JComponent comp = (JComponent) me.getSource();
//                TransferHandler handler = comp.getTransferHandler();
//                handler.exportAsDrag(comp, me, TransferHandler.COPY);
//            }
//        };
//        G.addMouseListener(listenerG1);
//
//        H.setTransferHandler(new TransferHandler("text"));
//        MouseListener listenerH1 = new MouseAdapter() {
//            public void mousePressed(MouseEvent me) {
//                JComponent comp = (JComponent) me.getSource();
//                TransferHandler handler = comp.getTransferHandler();
//                handler.exportAsDrag(comp, me, TransferHandler.COPY);
//            }
//        };
//        H.addMouseListener(listenerH1);
//
//        J.setTransferHandler(new TransferHandler("text"));
//        MouseListener listenerJ1 = new MouseAdapter() {
//            public void mousePressed(MouseEvent me) {
//                JComponent comp = (JComponent) me.getSource();
//                TransferHandler handler = comp.getTransferHandler();
//                handler.exportAsDrag(comp, me, TransferHandler.COPY);
//            }
//        };
//        J.addMouseListener(listenerJ1);
//
//        K.setTransferHandler(new TransferHandler("text"));
//        MouseListener listenerK1 = new MouseAdapter() {
//            public void mousePressed(MouseEvent me) {
//                JComponent comp = (JComponent) me.getSource();
//                TransferHandler handler = comp.getTransferHandler();
//                handler.exportAsDrag(comp, me, TransferHandler.COPY);
//            }
//        };
//        K.addMouseListener(listenerK1);
//
//        L.setTransferHandler(new TransferHandler("text"));
//        MouseListener listenerL1 = new MouseAdapter() {
//            public void mousePressed(MouseEvent me) {
//                JComponent comp = (JComponent) me.getSource();
//                TransferHandler handler = comp.getTransferHandler();
//                handler.exportAsDrag(comp, me, TransferHandler.COPY);
//            }
//        };
//        L.addMouseListener(listenerL1);
//
//        M.setTransferHandler(new TransferHandler("text"));
//        MouseListener listenerM1 = new MouseAdapter() {
//            public void mousePressed(MouseEvent me) {
//                JComponent comp = (JComponent) me.getSource();
//                TransferHandler handler = comp.getTransferHandler();
//                handler.exportAsDrag(comp, me, TransferHandler.COPY);
//            }
//        };
//        M.addMouseListener(listenerM1);
//
//        P.setTransferHandler(new TransferHandler("text"));
//        MouseListener listenerP1 = new MouseAdapter() {
//            public void mousePressed(MouseEvent me) {
//                JComponent comp = (JComponent) me.getSource();
//                TransferHandler handler = comp.getTransferHandler();
//                handler.exportAsDrag(comp, me, TransferHandler.COPY);
//            }
//        };
//        P.addMouseListener(listenerP1);
//
//        if ((R.getText().equals("N"))) {
//
//            R.setTransferHandler(new TransferHandler("text"));
//            MouseListener listenerR1 = new MouseAdapter() {
//                public void mousePressed(MouseEvent me) {
//                    JComponent comp = (JComponent) me.getSource();
//                    TransferHandler handler = comp.getTransferHandler();
//                    handler.exportAsDrag(comp, me, TransferHandler.COPY);
//                }
//            };
//            R.addMouseListener(listenerR1);
//
//        } else {
//
//            R.setTransferHandler(new TransferHandler("abc"));
//            MouseListener listenerR1 = new MouseAdapter() {
//                public void mousePressed(MouseEvent me) {
//                    JComponent comp = (JComponent) me.getSource();
//                    TransferHandler handler = comp.getTransferHandler();
//                    handler.exportAsDrag(comp, me, TransferHandler.COPY);
//                }
//            };
//            R.addMouseListener(listenerR1);
//        }
//
//        if ((S.getText().equals("N"))) {
//            S.setTransferHandler(new TransferHandler("text"));
//            MouseListener listenerS1 = new MouseAdapter() {
//                public void mousePressed(MouseEvent me) {
//                    JComponent comp = (JComponent) me.getSource();
//                    TransferHandler handler = comp.getTransferHandler();
//                    handler.exportAsDrag(comp, me, TransferHandler.COPY);
//                }
//            };
//            S.addMouseListener(listenerS1);
//
//        } else {
//            S.setTransferHandler(new TransferHandler("abc"));
//            MouseListener listenerS1 = new MouseAdapter() {
//                public void mousePressed(MouseEvent me) {
//                    JComponent comp = (JComponent) me.getSource();
//                    TransferHandler handler = comp.getTransferHandler();
//                    handler.exportAsDrag(comp, me, TransferHandler.COPY);
//                }
//            };
//            S.addMouseListener(listenerS1);
//
//        }
//
//        if ((T.getText().equals("N"))) {
//            T.setTransferHandler(new TransferHandler("text"));
//            MouseListener listenerT1 = new MouseAdapter() {
//                public void mousePressed(MouseEvent me) {
//                    JComponent comp = (JComponent) me.getSource();
//                    TransferHandler handler = comp.getTransferHandler();
//                    handler.exportAsDrag(comp, me, TransferHandler.COPY);
//                }
//            };
//            T.addMouseListener(listenerT1);
//
//        } else {
//            T.setTransferHandler(new TransferHandler("abc"));
//            MouseListener listenerT1 = new MouseAdapter() {
//                public void mousePressed(MouseEvent me) {
//                    JComponent comp = (JComponent) me.getSource();
//                    TransferHandler handler = comp.getTransferHandler();
//                    handler.exportAsDrag(comp, me, TransferHandler.COPY);
//                }
//            };
//            T.addMouseListener(listenerT1);
//
//        }
//
//        if ((U.getText().equals("N"))) {
//            U.setTransferHandler(new TransferHandler("text"));
//            MouseListener listenerU1 = new MouseAdapter() {
//                public void mousePressed(MouseEvent me) {
//                    JComponent comp = (JComponent) me.getSource();
//                    TransferHandler handler = comp.getTransferHandler();
//                    handler.exportAsDrag(comp, me, TransferHandler.COPY);
//                }
//            };
//            U.addMouseListener(listenerU1);
//
//        } else {
//            U.setTransferHandler(new TransferHandler("abc"));
//            MouseListener listenerU1 = new MouseAdapter() {
//                public void mousePressed(MouseEvent me) {
//                    JComponent comp = (JComponent) me.getSource();
//                    TransferHandler handler = comp.getTransferHandler();
//                    handler.exportAsDrag(comp, me, TransferHandler.COPY);
//                }
//            };
//            U.addMouseListener(listenerU1);
//
//        }
//        if ((AA.getText().equals("N"))) {
//            AA.setTransferHandler(new TransferHandler("text"));
//            MouseListener listenerAA1 = new MouseAdapter() {
//                public void mousePressed(MouseEvent me) {
//                    JComponent comp = (JComponent) me.getSource();
//                    TransferHandler handler = comp.getTransferHandler();
//                    handler.exportAsDrag(comp, me, TransferHandler.COPY);
//                }
//            };
//            AA.addMouseListener(listenerAA1);
//        } 
//        else
//        {
//            AA.setTransferHandler(new TransferHandler("abc"));
//            MouseListener listenerAA1 = new MouseAdapter() {
//                public void mousePressed(MouseEvent me) {
//                    JComponent comp = (JComponent) me.getSource();
//                    TransferHandler handler = comp.getTransferHandler();
//                    handler.exportAsDrag(comp, me, TransferHandler.COPY);
//                }
//            };
//            AA.addMouseListener(listenerAA1);
//
//        }
//         if ((BB.getText().equals("N"))) {
//        BB.setTransferHandler(new TransferHandler("text"));
//        MouseListener listenerBB1 = new MouseAdapter() {
//            public void mousePressed(MouseEvent me) {
//                JComponent comp = (JComponent) me.getSource();
//                TransferHandler handler = comp.getTransferHandler();
//                handler.exportAsDrag(comp, me, TransferHandler.COPY);
//            }
//        };
//        BB.addMouseListener(listenerBB1);
//         }
//          if ((CC.getText().equals("N"))) {
//        CC.setTransferHandler(new TransferHandler("text"));
//        MouseListener listenerCC1 = new MouseAdapter() {
//            public void mousePressed(MouseEvent me) {
//                JComponent comp = (JComponent) me.getSource();
//                TransferHandler handler = comp.getTransferHandler();
//                handler.exportAsDrag(comp, me, TransferHandler.COPY);
//            }
//        };
//        CC.addMouseListener(listenerCC1);
//          }
//        DD.setTransferHandler(new TransferHandler("text"));
//        MouseListener listenerDD1 = new MouseAdapter() {
//            public void mousePressed(MouseEvent me) {
//                JComponent comp = (JComponent) me.getSource();
//                TransferHandler handler = comp.getTransferHandler();
//                handler.exportAsDrag(comp, me, TransferHandler.COPY);
//            }
//        };
//        DD.addMouseListener(listenerDD1);
//
//        EE.setTransferHandler(new TransferHandler("text"));
//        MouseListener listenerEE1 = new MouseAdapter() {
//            public void mousePressed(MouseEvent me) {
//                JComponent comp = (JComponent) me.getSource();
//                TransferHandler handler = comp.getTransferHandler();
//                handler.exportAsDrag(comp, me, TransferHandler.COPY);
//            }
//        };
//        EE.addMouseListener(listenerEE1);
//
//        FF.setTransferHandler(new TransferHandler("text"));
//        MouseListener listenerFF1 = new MouseAdapter() {
//            public void mousePressed(MouseEvent me) {
//                JComponent comp = (JComponent) me.getSource();
//                TransferHandler handler = comp.getTransferHandler();
//                handler.exportAsDrag(comp, me, TransferHandler.COPY);
//            }
//        };
//        FF.addMouseListener(listenerFF1);
//
//        GG.setTransferHandler(new TransferHandler("text"));
//        MouseListener listenerGG1 = new MouseAdapter() {
//            public void mousePressed(MouseEvent me) {
//                JComponent comp = (JComponent) me.getSource();
//                TransferHandler handler = comp.getTransferHandler();
//                handler.exportAsDrag(comp, me, TransferHandler.COPY);
//            }
//        };
//        GG.addMouseListener(listenerGG1);
//
//        HH.setTransferHandler(new TransferHandler("text"));
//        MouseListener listenerHH1 = new MouseAdapter() {
//            public void mousePressed(MouseEvent me) {
//                JComponent comp = (JComponent) me.getSource();
//                TransferHandler handler = comp.getTransferHandler();
//                handler.exportAsDrag(comp, me, TransferHandler.COPY);
//            }
//        };
//        HH.addMouseListener(listenerHH1);
//
//        JJ.setTransferHandler(new TransferHandler("text"));
//        MouseListener listenerJJ1 = new MouseAdapter() {
//            public void mousePressed(MouseEvent me) {
//                JComponent comp = (JComponent) me.getSource();
//                TransferHandler handler = comp.getTransferHandler();
//                handler.exportAsDrag(comp, me, TransferHandler.COPY);
//            }
//        };
//        JJ.addMouseListener(listenerJJ1);
//
//        KK.setTransferHandler(new TransferHandler("text"));
//        MouseListener listenerKK1 = new MouseAdapter() {
//            public void mousePressed(MouseEvent me) {
//                JComponent comp = (JComponent) me.getSource();
//                TransferHandler handler = comp.getTransferHandler();
//                handler.exportAsDrag(comp, me, TransferHandler.COPY);
//            }
//        };
//        KK.addMouseListener(listenerKK1);
//
//        LL.setTransferHandler(new TransferHandler("text"));
//        MouseListener listenerLL1 = new MouseAdapter() {
//            public void mousePressed(MouseEvent me) {
//                JComponent comp = (JComponent) me.getSource();
//                TransferHandler handler = comp.getTransferHandler();
//                handler.exportAsDrag(comp, me, TransferHandler.COPY);
//            }
//        };
//        LL.addMouseListener(listenerLL1);
//
//        MM.setTransferHandler(new TransferHandler("text"));
//        MouseListener listenerMM1 = new MouseAdapter() {
//            public void mousePressed(MouseEvent me) {
//                JComponent comp = (JComponent) me.getSource();
//                TransferHandler handler = comp.getTransferHandler();
//                handler.exportAsDrag(comp, me, TransferHandler.COPY);
//            }
//        };
//        MM.addMouseListener(listenerMM1);
//
//        PP.setTransferHandler(new TransferHandler("text"));
//        MouseListener listenerPP1 = new MouseAdapter() {
//            public void mousePressed(MouseEvent me) {
//                JComponent comp = (JComponent) me.getSource();
//                TransferHandler handler = comp.getTransferHandler();
//                handler.exportAsDrag(comp, me, TransferHandler.COPY);
//            }
//        };
//        PP.addMouseListener(listenerPP1);
//
//        RR.setTransferHandler(new TransferHandler("text"));
//        MouseListener listenerRR1 = new MouseAdapter() {
//            public void mousePressed(MouseEvent me) {
//                JComponent comp = (JComponent) me.getSource();
//                TransferHandler handler = comp.getTransferHandler();
//                handler.exportAsDrag(comp, me, TransferHandler.COPY);
//            }
//        };
//        RR.addMouseListener(listenerRR1);
//
//        SS.setTransferHandler(new TransferHandler("text"));
//        MouseListener listenerSS1 = new MouseAdapter() {
//            public void mousePressed(MouseEvent me) {
//                JComponent comp = (JComponent) me.getSource();
//                TransferHandler handler = comp.getTransferHandler();
//                handler.exportAsDrag(comp, me, TransferHandler.COPY);
//            }
//        };
//        SS.addMouseListener(listenerSS1);
//
//        TT.setTransferHandler(new TransferHandler("text"));
//        MouseListener listenerTT1 = new MouseAdapter() {
//            public void mousePressed(MouseEvent me) {
//                JComponent comp = (JComponent) me.getSource();
//                TransferHandler handler = comp.getTransferHandler();
//                handler.exportAsDrag(comp, me, TransferHandler.COPY);
//            }
//        };
//        TT.addMouseListener(listenerTT1);
//
//        jLabel8.setTransferHandler(new TransferHandler("text"));
//        MouseListener listener = new MouseAdapter() {
//            public void mousePressed(MouseEvent me) {
//                JComponent comp = (JComponent) me.getSource();
//                TransferHandler handler = comp.getTransferHandler();
//                handler.exportAsDrag(comp, me, TransferHandler.COPY);
//            }
//        };
//        jLabel8.addMouseListener(listener);
//
//        jLabel10.setTransferHandler(new TransferHandler("text"));
//        MouseListener listener1 = new MouseAdapter() {
//            public void mousePressed(MouseEvent me) {
//                JComponent comp = (JComponent) me.getSource();
//                TransferHandler handler = comp.getTransferHandler();
//                handler.exportAsDrag(comp, me, TransferHandler.COPY);
//            }
//        };
//        jLabel10.addMouseListener(listener1);

    }//dragApply close

    public JLabel stringToExistingBoxLabel(String str) {
        if (str.equals("A")) {
            JLabel lb = A;
            return lb;
        }
        if (str.equals("B")) {
            JLabel lb = B;
            return lb;
        }
        if (str.equals("C")) {
            JLabel lb = C;
            return lb;
        }
        if (str.equals("D")) {
            JLabel lb = D;
            return lb;
        }
        if (str.equals("E")) {
            JLabel lb = E;
            return lb;
        }
        if (str.equals("F")) {
            JLabel lb = F;
            return lb;
        }
        if (str.equals("G")) {
            JLabel lb = G;
            return lb;
        }
        if (str.equals("H")) {
            JLabel lb = H;
            return lb;
        }
        if (str.equals("J")) {
            JLabel lb = J;
            return lb;
        }
        if (str.equals("K")) {
            JLabel lb = K;
            return lb;
        }
        if (str.equals("L")) {
            JLabel lb = L;
            return lb;
        }
        if (str.equals("M")) {
            JLabel lb = M;
            return lb;
        }
        if (str.equals("P")) {
            JLabel lb = P;
            return lb;
        }
        if (str.equals("R")) {
            JLabel lb = R;
            return lb;
        }
        if (str.equals("S")) {
            JLabel lb = S;
            return lb;
        }
        if (str.equals("T")) {
            JLabel lb = T;
            return lb;
        }
        if (str.equals("U")) {
            JLabel lb = U;
            return lb;
        }

        if (str.equals("AA")) {
            JLabel lb = AA;
            return lb;
        }
        if (str.equals("BB")) {
            JLabel lb = BB;
            return lb;
        }
        if (str.equals("CC")) {
            JLabel lb = CC;
            return lb;
        }
        if (str.equals("DD")) {
            JLabel lb = DD;
            return lb;
        }
        if (str.equals("EE")) {
            JLabel lb = EE;
            return lb;
        }
        if (str.equals("FF")) {
            JLabel lb = FF;
            return lb;
        }
        if (str.equals("GG")) {
            JLabel lb = GG;
            return lb;
        }
        if (str.equals("HH")) {
            JLabel lb = HH;
            return lb;
        }
        if (str.equals("JJ")) {
            JLabel lb = JJ;
            return lb;
        }
        if (str.equals("KK")) {
            JLabel lb = KK;
            return lb;
        }
        if (str.equals("LL")) {
            JLabel lb = LL;
            return lb;
        }
        if (str.equals("MM")) {
            JLabel lb = MM;
            return lb;
        }
        if (str.equals("PP")) {
            JLabel lb = PP;
            return lb;
        }
        if (str.equals("RR")) {
            JLabel lb = RR;
            return lb;
        }
        if (str.equals("SS")) {
            JLabel lb = SS;
            return lb;
        }
        if (str.equals("TT")) {
            JLabel lb = TT;
            return lb;
        }
        if (str.equals("AB")) {
            JLabel lb = AB;
            return lb;
        }
        if (str.equals("BC")) {
            JLabel lb = BC;
            return lb;
        }
        if (str.equals("CE")) {
            JLabel lb = CE;
            return lb;
        }
        if (str.equals("EF")) {
            JLabel lb = EF;
            return lb;
        }
        if (str.equals("FH")) {
            JLabel lb = FH;
            return lb;
        }
        if (str.equals("HJ")) {
            JLabel lb = HJ;
            return lb;
        }
        if (str.equals("JK")) {
            JLabel lb = JK;
            return lb;
        }
        if (str.equals("KM")) {
            JLabel lb = KM;
            return lb;
        }
        if (str.equals("MP")) {
            JLabel lb = MP;
            return lb;
        }
        if (str.equals("ABR")) {
            JLabel lb = ABR;
            return lb;
        }
        if (str.equals("BCR")) {
            JLabel lb = BCR;
            return lb;
        }
        if (str.equals("CER")) {
            JLabel lb = CER;
            return lb;
        }
        if (str.equals("EFR")) {
            JLabel lb = EFR;
            return lb;
        }
        if (str.equals("FHR")) {
            JLabel lb = FHR;
            return lb;
        }
        if (str.equals("HJR")) {
            JLabel lb = HJR;
            return lb;
        }
        if (str.equals("JKR")) {
            JLabel lb = JKR;
            return lb;
        }
        if (str.equals("KMR")) {
            JLabel lb = KMR;
            return lb;
        }
        if (str.equals("MPR")) {
            JLabel lb = MPR;
            return lb;
        }
        if (str.equals("PRR")) {
            JLabel lb = PRR;
            return lb;
        }

        if (str.equals("ABL")) {
            JLabel lb = ABL;
            return lb;
        }
        if (str.equals("BCL")) {
            JLabel lb = BCL;
            return lb;
        }
        if (str.equals("CEL")) {
            JLabel lb = CEL;
            return lb;
        }
        if (str.equals("EFL")) {
            JLabel lb = EFL;
            return lb;
        }
        if (str.equals("FHL")) {
            JLabel lb = FHL;
            return lb;
        }
        if (str.equals("HJL")) {
            JLabel lb = HJL;
            return lb;
        }
        if (str.equals("JKL")) {
            JLabel lb = JKL;
            return lb;
        }
        if (str.equals("KML")) {
            JLabel lb = KML;
            return lb;
        }
        if (str.equals("MPL")) {
            JLabel lb = MPL;
            return lb;
        }
        if (str.equals("PRL")) {
            JLabel lb = PRL;
            return lb;
        }

        if (str.equals("CFR")) {
            JLabel lb = CFR;
            return lb;
        }
        if (str.equals("FJR")) {
            JLabel lb = FJR;
            return lb;
        }
        if (str.equals("JLR")) {
            JLabel lb = JLR;
            return lb;
        }
        if (str.equals("LPR")) {
            JLabel lb = LPR;
            return lb;
        }
        if (str.equals("CFG")) {
            JLabel lb = CFG;
            return lb;
        }
        if (str.equals("FJG")) {
            JLabel lb = FJG;
            return lb;
        }
        if (str.equals("JLG")) {
            JLabel lb = JLG;
            return lb;
        }
        return null;

    }

    public void updateMainDeck() {
        String sql = " SELECT  * FROM Deadload where FLT_NO = ANY (select FLT_NO from newFlight where Active = 'yes') AND Location != '' AND Location != 'off' AND  Location != 'null';";
        try {
            con = Connect.ConnectDB();
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                String uld = rs.getString("ULD/Bulk");
                String gross = Integer.toString(rs.getInt("gross"));
                //String n = Integer.toString(rs.getInt("Net Weight"));
                String tare = Integer.toString(rs.getInt("TARE"));
                // String h = Integer.toString(rs.getInt("Height"));
                String dest = rs.getString("Dest");
                String commodity = rs.getString("Commodity");
                String loc = rs.getString("Location");
                //  String dg = rs.getString("DG/SL");
                //  boolean o = Boolean.parseBoolean(rs.getString("Overhang"));
                // boolean sxs = Boolean.parseBoolean(rs.getString("SxS"));

                String on = rs.getString("Onward");
                String ds = rs.getString("Description");

                JLabel lebel = stringToExistingBoxLabel(loc);
                backgroundDistributionBlock(lebel);
                lebel.setText("<html>" + uld + "<br>" + gross + "<br>" + tare + "<br>" + dest + " \\ " + commodity + "</html>");
                lebel.setToolTipText(lebel.getText());

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

    }

    public void ConstructorCode() {
        try {

            con = Connect.ConnectDB();
            String sq5 = "SELECT * FROM newFlight where Active = 'yes'";
            pst = con.prepareStatement(sq5);
            rs = pst.executeQuery();

            if (rs.next()) {
                showInfoFlightData();
            }
            cycle();
            setDOW_I();
            dragApply();
            updateMainDeck();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    public void deadload_update() {

        DefaultTableModel DFT = (DefaultTableModel) deadload1.getModel();
        DFT.setRowCount(0);
        String sql = "SELECT  * FROM Deadload where FLT_NO = ANY (select FLT_NO from newFlight where Active = 'yes') Order by Sr DESC";
        try {
            con = Connect.ConnectDB();
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            int i = 0;
            while (rs.next()) {
                String b = rs.getString("ULD/Bulk");
                String g = Integer.toString(rs.getInt("gross"));
                String n = Integer.toString(rs.getInt("Net Weight"));
                String t = Integer.toString(rs.getInt("TARE"));
                String h = Integer.toString(rs.getInt("Height"));
                String d = rs.getString("Dest");
                String c = rs.getString("Commodity");
                String l = rs.getString("Location");
                String dg = rs.getString("DG/SL");
                boolean o = Boolean.parseBoolean(rs.getString("Overhang"));
                boolean sxs = Boolean.parseBoolean(rs.getString("SxS"));

                String on = rs.getString("Onward");
                String ds = rs.getString("Description");

                DFT.insertRow(i, new Object[]{b, g, n, t, h, d, c, l, dg, o, sxs, on, ds});
                //deadload1.setRowSelectionInterval(0, 0);
                i++;
            }
//          deadload1.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

    }

    public void deadload_update_distribution() {

        DefaultTableModel DFT = (DefaultTableModel) deadload2.getModel();
        DFT.setRowCount(0);
        String sql = "SELECT  * FROM Deadload where FLT_NO = ANY (select FLT_NO from newFlight where Active = 'yes') and Location = '' Order by Sr DESC";
        try {
            con = Connect.ConnectDB();
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            int i = 0;
            while (rs.next()) {
                String sr = Integer.toString(rs.getInt("sr"));
                String b = rs.getString("ULD/Bulk");
                String g = Integer.toString(rs.getInt("gross"));
                String n = Integer.toString(rs.getInt("Net Weight"));
                String t = Integer.toString(rs.getInt("TARE"));
                String h = Integer.toString(rs.getInt("Height"));
                String d = rs.getString("Dest");
                String c = rs.getString("Commodity");
                String l = rs.getString("Location");
                String dg = rs.getString("DG/SL");
                boolean o = Boolean.parseBoolean(rs.getString("Overhang"));
                boolean sxs = Boolean.parseBoolean(rs.getString("SxS"));

                String on = rs.getString("Onward");
                String ds = rs.getString("Description");

                DFT.insertRow(i, new Object[]{sr, b, g, n, t, h, d, c, l, dg, o, sxs, on, ds});
                //deadload2.setRowSelectionInterval(0, 0);
                i++;

            }
//          deadload1.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

    }

    public FlightInfo() {
        initComponents();

        this.pattern = Pattern.compile("[012]{1}\\d{1}:[0123456]{1}\\d{1}");

        displayPublication();
        displayFuelInfo();
        GetFuelIndex();
        GetDensityList();
        title.setText("Flight Info");
        switchPanels(flightInfoPanel);
        dow.setText("");
        doi.setText("");
        ConstructorCode();

        deadload_update();

        deadload_update_distribution();

        jPanel4.setVisible(false);

        Thread t = new Thread(this);
        t.start();
        //  clock();
    }

    public void cycle() {

        check1.setVisible(false);
        check2.setVisible(false);
        check3.setVisible(false);
        check4.setVisible(false);
        check5.setVisible(false);
        check6.setVisible(false);
        check7.setVisible(false);
        check8.setVisible(false);
        check9.setVisible(false);
        check10.setVisible(false);
        check11.setVisible(false);
        check12.setVisible(false);
        check13.setVisible(false);
        check14.setVisible(false);
        check15.setVisible(false);
        check16.setVisible(false);
        check17.setVisible(false);
        check18.setVisible(false);
        check19.setVisible(false);
        check20.setVisible(false);
        check21.setVisible(false);
        check22.setVisible(false);
        check23.setVisible(false);
        check24.setVisible(false);
        check25.setVisible(false);

        flight1 = "";
        flight2 = "";
        flight3 = "";
        flight4 = "";

        flight5 = "";
        flight6 = "";
        flight7 = "";
        flight8 = "";
        flight9 = "";
        flight10 = "";
        flight11 = "";
        flight12 = "";
        flight13 = "";
        flight14 = "";
        flight15 = "";
        flight16 = "";
        flight17 = "";
        flight18 = "";
        flight19 = "";
        flight20 = "";
        flight21 = "";
        flight22 = "";
        flight23 = "";
        flight24 = "";
        flight25 = "";
        list1.setText("");
        list2.setText("");
        list3.setText("");
        list4.setText("");
        list5.setText("");
        list6.setText("");
        list7.setText("");
        list8.setText("");
        list9.setText("");
        list10.setText("");
        list11.setText("");
        list12.setText("");
        list13.setText("");
        list14.setText("");
        list15.setText("");
        list16.setText("");
        list17.setText("");
        list18.setText("");
        list19.setText("");
        list20.setText("");
        list21.setText("");
        list22.setText("");
        list23.setText("");
        list24.setText("");
        list25.setText("");

        flightInfo_Update();
        update();

    }

    private void GetDensityList() {

        String sql = "SELECT Density from density";
        try {
            con = Connect.ConnectDB();
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                density_combo.addItem(rs.getString("Density"));

            }

            density_combo.setSelectedItem("0.79");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void GetFuelIndex() {
        String sql = "SELECT *  FROM [Standard fuel index]";
        try {
            con = Connect.ConnectDB();
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            jTable2.setModel(DbUtils.resultSetToTableModel(rs));
            jTable2.getColumnModel().getColumn(0).setResizable(false);
            jTable2.getColumnModel().getColumn(0).setPreferredWidth(100);
            jTable2.getColumnModel().getColumn(1).setResizable(false);
            jTable2.getColumnModel().getColumn(1).setPreferredWidth(60);
            jTable2.getColumnModel().getColumn(2).setResizable(false);
            jTable2.getColumnModel().getColumn(2).setPreferredWidth(60);
            jTable2.getColumnModel().getColumn(3).setResizable(false);
            jTable2.getColumnModel().getColumn(3).setPreferredWidth(60);
            jTable2.getColumnModel().getColumn(4).setResizable(false);
            jTable2.getColumnModel().getColumn(4).setPreferredWidth(60);
            jTable2.getColumnModel().getColumn(5).setResizable(false);
            jTable2.getColumnModel().getColumn(5).setPreferredWidth(60);
            jTable2.getColumnModel().getColumn(6).setResizable(false);
            jTable2.getColumnModel().getColumn(6).setPreferredWidth(60);
            jTable2.getColumnModel().getColumn(7).setResizable(false);
            jTable2.getColumnModel().getColumn(7).setPreferredWidth(60);
            jTable2.getColumnModel().getColumn(8).setResizable(false);
            jTable2.getColumnModel().getColumn(8).setPreferredWidth(60);
            jTable2.getColumnModel().getColumn(9).setResizable(false);
            jTable2.getColumnModel().getColumn(9).setPreferredWidth(60);
            jTable2.getColumnModel().getColumn(10).setResizable(false);
            jTable2.getColumnModel().getColumn(10).setPreferredWidth(60);
            jTable2.getColumnModel().getColumn(11).setResizable(false);
            jTable2.getColumnModel().getColumn(11).setPreferredWidth(60);
            jTable2.getColumnModel().getColumn(12).setResizable(false);
            jTable2.getColumnModel().getColumn(12).setPreferredWidth(60);
            jTable2.getColumnModel().getColumn(13).setResizable(false);
            jTable2.getColumnModel().getColumn(13).setPreferredWidth(60);
            jTable2.getColumnModel().getColumn(14).setResizable(false);
            jTable2.getColumnModel().getColumn(14).setPreferredWidth(60);
            jTable2.getColumnModel().getColumn(15).setResizable(false);
            jTable2.getColumnModel().getColumn(15).setPreferredWidth(60);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        closebtn = new javax.swing.JButton();
        minimizebtn = new javax.swing.JButton();
        fullbtn = new javax.swing.JButton();
        title = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        more = new javax.swing.JComboBox<>();
        logout = new javax.swing.JButton();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        flightCreatorPanel = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        f_flight_no = new javax.swing.JTextField();
        f_org = new javax.swing.JTextField();
        f_dest1 = new javax.swing.JTextField();
        f_dest2 = new javax.swing.JTextField();
        f_dest3 = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        f_std = new javax.swing.JTextField();
        f_create = new javax.swing.JButton();
        f_ac = new javax.swing.JComboBox<>();
        f_reg = new javax.swing.JComboBox<>();
        jPanel8 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        f_date = new com.toedter.calendar.JDateChooser();
        documentsPanel = new javax.swing.JPanel();
        leteralImbalancePanel = new javax.swing.JPanel();
        lmcPanel = new javax.swing.JPanel();
        selectFlightPanel = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jPanel11 = new javax.swing.JPanel();
        check1 = new javax.swing.JCheckBox();
        check2 = new javax.swing.JCheckBox();
        check3 = new javax.swing.JCheckBox();
        check4 = new javax.swing.JCheckBox();
        check5 = new javax.swing.JCheckBox();
        check6 = new javax.swing.JCheckBox();
        check7 = new javax.swing.JCheckBox();
        check8 = new javax.swing.JCheckBox();
        check9 = new javax.swing.JCheckBox();
        check10 = new javax.swing.JCheckBox();
        check11 = new javax.swing.JCheckBox();
        check12 = new javax.swing.JCheckBox();
        check13 = new javax.swing.JCheckBox();
        check14 = new javax.swing.JCheckBox();
        check15 = new javax.swing.JCheckBox();
        check16 = new javax.swing.JCheckBox();
        check17 = new javax.swing.JCheckBox();
        check18 = new javax.swing.JCheckBox();
        check19 = new javax.swing.JCheckBox();
        check20 = new javax.swing.JCheckBox();
        check21 = new javax.swing.JCheckBox();
        check22 = new javax.swing.JCheckBox();
        check23 = new javax.swing.JCheckBox();
        check24 = new javax.swing.JCheckBox();
        check25 = new javax.swing.JCheckBox();
        jLabel40 = new javax.swing.JLabel();
        jButton14 = new javax.swing.JButton();
        unload = new javax.swing.JButton();
        jButton28 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        flighteditPanel1 = new javax.swing.JPanel();
        jLabel74 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        jLabel118 = new javax.swing.JLabel();
        jLabel119 = new javax.swing.JLabel();
        jLabel120 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        jTextField14 = new javax.swing.JTextField();
        jTextField16 = new javax.swing.JTextField();
        jTextField17 = new javax.swing.JTextField();
        jTextField18 = new javax.swing.JTextField();
        jLabel121 = new javax.swing.JLabel();
        jLabel122 = new javax.swing.JLabel();
        jLabel123 = new javax.swing.JLabel();
        jTextField19 = new javax.swing.JTextField();
        jButton22 = new javax.swing.JButton();
        jButton23 = new javax.swing.JButton();
        jButton24 = new javax.swing.JButton();
        jComboBox3 = new javax.swing.JComboBox<>();
        jComboBox4 = new javax.swing.JComboBox<>();
        jPanel16 = new javax.swing.JPanel();
        jLabel124 = new javax.swing.JLabel();
        jComboBox8 = new javax.swing.JComboBox<>();
        jLabel125 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField20 = new javax.swing.JTextField();
        jLabel126 = new javax.swing.JLabel();
        jLabel127 = new javax.swing.JLabel();
        jLabel128 = new javax.swing.JLabel();
        jCheckBox5 = new javax.swing.JCheckBox();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        deadloadPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        deadload1 = new javax.swing.JTable();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        apply = new javax.swing.JButton();
        jLabel129 = new javax.swing.JLabel();
        jLabel130 = new javax.swing.JLabel();
        jLabel131 = new javax.swing.JLabel();
        jLabel132 = new javax.swing.JLabel();
        jLabel133 = new javax.swing.JLabel();
        jLabel134 = new javax.swing.JLabel();
        jLabel135 = new javax.swing.JLabel();
        jLabel136 = new javax.swing.JLabel();
        jLabel137 = new javax.swing.JLabel();
        jLabel138 = new javax.swing.JLabel();
        jLabel139 = new javax.swing.JLabel();
        jLabel140 = new javax.swing.JLabel();
        jLabel141 = new javax.swing.JLabel();
        jLabel142 = new javax.swing.JLabel();
        jLabel143 = new javax.swing.JLabel();
        jLabel144 = new javax.swing.JLabel();
        fuelPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel17 = new javax.swing.JPanel();
        jLabel145 = new javax.swing.JLabel();
        jLabel146 = new javax.swing.JLabel();
        jLabel147 = new javax.swing.JLabel();
        jLabel148 = new javax.swing.JLabel();
        jLabel149 = new javax.swing.JLabel();
        jLabel150 = new javax.swing.JLabel();
        jLabel151 = new javax.swing.JLabel();
        fuel_distri_combo = new javax.swing.JComboBox<>();
        block_f = new javax.swing.JTextField();
        taxi_f = new javax.swing.JTextField();
        trip_f = new javax.swing.JTextField();
        unusable_f = new javax.swing.JTextField();
        density_combo = new javax.swing.JComboBox<>();
        jButton25 = new javax.swing.JButton();
        trip_i = new javax.swing.JLabel();
        unusable_i = new javax.swing.JLabel();
        block_i = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jLabel153 = new javax.swing.JLabel();
        jLabel154 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        jLabel152 = new javax.swing.JLabel();
        flightInfoPanel = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        dow = new javax.swing.JLabel();
        w_fwd = new javax.swing.JLabel();
        w_ctr = new javax.swing.JLabel();
        w_aft = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        doi = new javax.swing.JLabel();
        i_fwd = new javax.swing.JLabel();
        i_ctr = new javax.swing.JLabel();
        i_aft = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel82 = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        jLabel85 = new javax.swing.JLabel();
        p_zfw = new javax.swing.JLabel();
        p_zemac = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        jLabel89 = new javax.swing.JLabel();
        jLabel90 = new javax.swing.JLabel();
        jLabel91 = new javax.swing.JLabel();
        jLabel92 = new javax.swing.JLabel();
        w_f_board = new javax.swing.JLabel();
        w_taxi = new javax.swing.JLabel();
        i_f_board = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jLabel96 = new javax.swing.JLabel();
        jLabel97 = new javax.swing.JLabel();
        jLabel98 = new javax.swing.JLabel();
        jLabel99 = new javax.swing.JLabel();
        p_tow = new javax.swing.JLabel();
        jLabel102 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jLabel101 = new javax.swing.JLabel();
        jLabel103 = new javax.swing.JLabel();
        jLabel104 = new javax.swing.JLabel();
        jLabel105 = new javax.swing.JLabel();
        jLabel107 = new javax.swing.JLabel();
        jLabel106 = new javax.swing.JLabel();
        jLabel108 = new javax.swing.JLabel();
        jLabel109 = new javax.swing.JLabel();
        jLabel110 = new javax.swing.JLabel();
        w_trip = new javax.swing.JLabel();
        w_landing = new javax.swing.JLabel();
        i_landing = new javax.swing.JLabel();
        i_trip = new javax.swing.JLabel();
        jLabel115 = new javax.swing.JLabel();
        p_ldw = new javax.swing.JLabel();
        jLabel117 = new javax.swing.JLabel();
        w_unusable = new javax.swing.JLabel();
        i_unusable = new javax.swing.JLabel();
        jButton10 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jLabel34 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        ac_type = new javax.swing.JLabel();
        route = new javax.swing.JLabel();
        date = new javax.swing.JLabel();
        std = new javax.swing.JLabel();
        crewCombo = new javax.swing.JComboBox<>();
        regCombo = new javax.swing.JComboBox<>();
        jButton9 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        jPanel151 = new javax.swing.JPanel();
        distributionPanel = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        CFG_panel = new javax.swing.JPanel();
        CFG = new javax.swing.JLabel();
        CFR_panel = new javax.swing.JPanel();
        CFR = new javax.swing.JLabel();
        FJG_panel = new javax.swing.JPanel();
        FJG = new javax.swing.JLabel();
        JLG_panel = new javax.swing.JPanel();
        JLG = new javax.swing.JLabel();
        FJR_panel = new javax.swing.JPanel();
        FJR = new javax.swing.JLabel();
        JLR_panel = new javax.swing.JPanel();
        JLR = new javax.swing.JLabel();
        LPR_panel = new javax.swing.JPanel();
        LPR = new javax.swing.JLabel();
        AB_panel = new javax.swing.JPanel();
        AB = new javax.swing.JLabel();
        BC_panel = new javax.swing.JPanel();
        BC = new javax.swing.JLabel();
        CE_panel = new javax.swing.JPanel();
        CE = new javax.swing.JLabel();
        EF_panel = new javax.swing.JPanel();
        EF = new javax.swing.JLabel();
        FH_panel = new javax.swing.JPanel();
        FH = new javax.swing.JLabel();
        HJ_panel = new javax.swing.JPanel();
        HJ = new javax.swing.JLabel();
        JK_panel = new javax.swing.JPanel();
        JK = new javax.swing.JLabel();
        KM_panel = new javax.swing.JPanel();
        KM = new javax.swing.JLabel();
        MP_panel = new javax.swing.JPanel();
        MP = new javax.swing.JLabel();
        A_panel = new javax.swing.JPanel();
        A = new javax.swing.JLabel();
        B_panel = new javax.swing.JPanel();
        B = new javax.swing.JLabel();
        C_panel = new javax.swing.JPanel();
        C = new javax.swing.JLabel();
        D_panel = new javax.swing.JPanel();
        D = new javax.swing.JLabel();
        E_panel = new javax.swing.JPanel();
        E = new javax.swing.JLabel();
        F_panel = new javax.swing.JPanel();
        F = new javax.swing.JLabel();
        G_panel = new javax.swing.JPanel();
        G = new javax.swing.JLabel();
        H_panel = new javax.swing.JPanel();
        H = new javax.swing.JLabel();
        J_panel = new javax.swing.JPanel();
        J = new javax.swing.JLabel();
        K_panel = new javax.swing.JPanel();
        K = new javax.swing.JLabel();
        L_panel = new javax.swing.JPanel();
        L = new javax.swing.JLabel();
        M_panel = new javax.swing.JPanel();
        M = new javax.swing.JLabel();
        P_panel = new javax.swing.JPanel();
        P = new javax.swing.JLabel();
        R_panel = new javax.swing.JPanel();
        R = new javax.swing.JLabel();
        S_panel = new javax.swing.JPanel();
        S = new javax.swing.JLabel();
        T_panel = new javax.swing.JPanel();
        T = new javax.swing.JLabel();
        U_panel = new javax.swing.JPanel();
        U = new javax.swing.JLabel();
        AA_panel = new javax.swing.JPanel();
        AA = new javax.swing.JLabel();
        BB_panel = new javax.swing.JPanel();
        BB = new javax.swing.JLabel();
        CC_panel = new javax.swing.JPanel();
        CC = new javax.swing.JLabel();
        DD_panel = new javax.swing.JPanel();
        DD = new javax.swing.JLabel();
        EE_panel = new javax.swing.JPanel();
        EE = new javax.swing.JLabel();
        FF_panel = new javax.swing.JPanel();
        FF = new javax.swing.JLabel();
        GG_panel = new javax.swing.JPanel();
        GG = new javax.swing.JLabel();
        HH_panel = new javax.swing.JPanel();
        HH = new javax.swing.JLabel();
        JJ_panel = new javax.swing.JPanel();
        JJ = new javax.swing.JLabel();
        KK_panel = new javax.swing.JPanel();
        KK = new javax.swing.JLabel();
        LL_panel = new javax.swing.JPanel();
        LL = new javax.swing.JLabel();
        MM_panel = new javax.swing.JPanel();
        MM = new javax.swing.JLabel();
        PP_panel = new javax.swing.JPanel();
        PP = new javax.swing.JLabel();
        RR_panel = new javax.swing.JPanel();
        RR = new javax.swing.JLabel();
        SS_panel = new javax.swing.JPanel();
        SS = new javax.swing.JLabel();
        TT_panel = new javax.swing.JPanel();
        TT = new javax.swing.JLabel();
        ABR_panel = new javax.swing.JPanel();
        ABR = new javax.swing.JLabel();
        ABL_panel = new javax.swing.JPanel();
        ABL = new javax.swing.JLabel();
        BCR_panel = new javax.swing.JPanel();
        BCR = new javax.swing.JLabel();
        BCL_panel = new javax.swing.JPanel();
        BCL = new javax.swing.JLabel();
        CER_panel = new javax.swing.JPanel();
        CER = new javax.swing.JLabel();
        CEL_panel = new javax.swing.JPanel();
        CEL = new javax.swing.JLabel();
        HJL_panel = new javax.swing.JPanel();
        HJL = new javax.swing.JLabel();
        FHL_panel = new javax.swing.JPanel();
        FHL = new javax.swing.JLabel();
        EFL_panel = new javax.swing.JPanel();
        EFL = new javax.swing.JLabel();
        EFR_panel = new javax.swing.JPanel();
        EFR = new javax.swing.JLabel();
        FHR_panel = new javax.swing.JPanel();
        FHR = new javax.swing.JLabel();
        HJR_panel = new javax.swing.JPanel();
        HJR = new javax.swing.JLabel();
        MPL_panel = new javax.swing.JPanel();
        MPL = new javax.swing.JLabel();
        KML_panel = new javax.swing.JPanel();
        KML = new javax.swing.JLabel();
        JKL_panel = new javax.swing.JPanel();
        JKL = new javax.swing.JLabel();
        JKR_panel = new javax.swing.JPanel();
        JKR = new javax.swing.JLabel();
        KMR_panel = new javax.swing.JPanel();
        KMR = new javax.swing.JLabel();
        MPR_panel = new javax.swing.JPanel();
        MPR = new javax.swing.JLabel();
        PRL_panel = new javax.swing.JPanel();
        PRL = new javax.swing.JLabel();
        PRR_panel = new javax.swing.JPanel();
        PRR = new javax.swing.JLabel();
        checkboxMD2 = new javax.swing.JCheckBox();
        checkboxMD1 = new javax.swing.JCheckBox();
        checkboxMD3 = new javax.swing.JCheckBox();
        checkboxMD16 = new javax.swing.JCheckBox();
        checkboxMD20 = new javax.swing.JCheckBox();
        jScrollPane4 = new javax.swing.JScrollPane();
        deadload2 = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton26 = new javax.swing.JButton();
        jButton27 = new javax.swing.JButton();
        jLabel33 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable6 = new javax.swing.JTable();
        jPanel91 = new javax.swing.JPanel();
        jPanel92 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel93 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel95 = new javax.swing.JPanel();
        jPanel96 = new javax.swing.JPanel();
        jPanel94 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jPanel99 = new javax.swing.JPanel();
        jPanel100 = new javax.swing.JPanel();
        jPanel123 = new javax.swing.JPanel();
        jPanel124 = new javax.swing.JPanel();
        jPanel125 = new javax.swing.JPanel();
        jPanel126 = new javax.swing.JPanel();
        jPanel127 = new javax.swing.JPanel();
        jPanel128 = new javax.swing.JPanel();
        jPanel129 = new javax.swing.JPanel();
        jPanel130 = new javax.swing.JPanel();
        jPanel131 = new javax.swing.JPanel();
        jPanel132 = new javax.swing.JPanel();
        jPanel133 = new javax.swing.JPanel();
        jPanel134 = new javax.swing.JPanel();
        jPanel135 = new javax.swing.JPanel();
        jPanel136 = new javax.swing.JPanel();
        jPanel137 = new javax.swing.JPanel();
        jPanel138 = new javax.swing.JPanel();
        jPanel139 = new javax.swing.JPanel();
        jPanel140 = new javax.swing.JPanel();
        jPanel141 = new javax.swing.JPanel();
        jPanel142 = new javax.swing.JPanel();
        jPanel147 = new javax.swing.JPanel();
        jPanel148 = new javax.swing.JPanel();
        jPanel149 = new javax.swing.JPanel();
        jPanel150 = new javax.swing.JPanel();
        jPanel101 = new javax.swing.JPanel();
        jPanel102 = new javax.swing.JPanel();
        jPanel103 = new javax.swing.JPanel();
        jPanel104 = new javax.swing.JPanel();
        jPanel105 = new javax.swing.JPanel();
        jPanel106 = new javax.swing.JPanel();
        jPanel107 = new javax.swing.JPanel();
        jPanel108 = new javax.swing.JPanel();
        jPanel109 = new javax.swing.JPanel();
        jPanel110 = new javax.swing.JPanel();
        jPanel97 = new javax.swing.JPanel();
        jPanel98 = new javax.swing.JPanel();
        jPanel111 = new javax.swing.JPanel();
        jPanel112 = new javax.swing.JPanel();
        jPanel113 = new javax.swing.JPanel();
        jPanel114 = new javax.swing.JPanel();
        jPanel115 = new javax.swing.JPanel();
        jPanel116 = new javax.swing.JPanel();
        jPanel117 = new javax.swing.JPanel();
        jPanel118 = new javax.swing.JPanel();
        jPanel119 = new javax.swing.JPanel();
        jPanel120 = new javax.swing.JPanel();
        jPanel121 = new javax.swing.JPanel();
        jPanel122 = new javax.swing.JPanel();
        jPanel143 = new javax.swing.JPanel();
        jPanel144 = new javax.swing.JPanel();
        jPanel145 = new javax.swing.JPanel();
        jPanel146 = new javax.swing.JPanel();
        jLabel160 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel161 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel155 = new javax.swing.JLabel();
        jLabel162 = new javax.swing.JLabel();
        jLabel156 = new javax.swing.JLabel();
        jLabel157 = new javax.swing.JLabel();
        jLabel158 = new javax.swing.JLabel();
        jLabel159 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        p1 = new javax.swing.JPanel();
        list1 = new javax.swing.JButton();
        p2 = new javax.swing.JPanel();
        list2 = new javax.swing.JButton();
        p3 = new javax.swing.JPanel();
        list3 = new javax.swing.JButton();
        p4 = new javax.swing.JPanel();
        list4 = new javax.swing.JButton();
        p5 = new javax.swing.JPanel();
        list5 = new javax.swing.JButton();
        p6 = new javax.swing.JPanel();
        list6 = new javax.swing.JButton();
        p7 = new javax.swing.JPanel();
        list7 = new javax.swing.JButton();
        p8 = new javax.swing.JPanel();
        list8 = new javax.swing.JButton();
        p9 = new javax.swing.JPanel();
        list9 = new javax.swing.JButton();
        p10 = new javax.swing.JPanel();
        list10 = new javax.swing.JButton();
        p11 = new javax.swing.JPanel();
        list11 = new javax.swing.JButton();
        p12 = new javax.swing.JPanel();
        list12 = new javax.swing.JButton();
        p13 = new javax.swing.JPanel();
        list13 = new javax.swing.JButton();
        p14 = new javax.swing.JPanel();
        list14 = new javax.swing.JButton();
        p15 = new javax.swing.JPanel();
        list15 = new javax.swing.JButton();
        p16 = new javax.swing.JPanel();
        list16 = new javax.swing.JButton();
        p17 = new javax.swing.JPanel();
        list17 = new javax.swing.JButton();
        p18 = new javax.swing.JPanel();
        list18 = new javax.swing.JButton();
        p19 = new javax.swing.JPanel();
        list19 = new javax.swing.JButton();
        p20 = new javax.swing.JPanel();
        list20 = new javax.swing.JButton();
        p21 = new javax.swing.JPanel();
        list21 = new javax.swing.JButton();
        p22 = new javax.swing.JPanel();
        list22 = new javax.swing.JButton();
        p23 = new javax.swing.JPanel();
        list23 = new javax.swing.JButton();
        p24 = new javax.swing.JPanel();
        list24 = new javax.swing.JButton();
        p25 = new javax.swing.JPanel();
        list25 = new javax.swing.JButton();
        jPanel152 = new javax.swing.JPanel();
        timeClock = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        hour24 = new javax.swing.JRadioButton();
        hour12 = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(39, 50, 56));
        setName("hello "); // NOI18N
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(39, 50, 56));
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel1MouseDragged(evt);
            }
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanel1MouseMoved(evt);
            }
        });
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jPanel1MouseReleased(evt);
            }
        });

        closebtn.setBackground(new java.awt.Color(39, 50, 56));
        closebtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        closebtn.setForeground(new java.awt.Color(255, 255, 255));
        closebtn.setText("X");
        closebtn.setBorder(null);
        closebtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                closebtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                closebtnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                closebtnMousePressed(evt);
            }
        });
        closebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closebtnActionPerformed(evt);
            }
        });

        minimizebtn.setBackground(new java.awt.Color(39, 50, 56));
        minimizebtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        minimizebtn.setForeground(new java.awt.Color(255, 255, 255));
        minimizebtn.setText("-");
        minimizebtn.setBorder(null);
        minimizebtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                minimizebtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                minimizebtnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                minimizebtnMousePressed(evt);
            }
        });
        minimizebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minimizebtnActionPerformed(evt);
            }
        });

        fullbtn.setBackground(new java.awt.Color(39, 50, 56));
        fullbtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        fullbtn.setForeground(new java.awt.Color(255, 255, 255));
        fullbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/rectangle.png"))); // NOI18N
        fullbtn.setBorder(null);
        fullbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                fullbtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                fullbtnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                fullbtnMousePressed(evt);
            }
        });
        fullbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fullbtnActionPerformed(evt);
            }
        });

        title.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        title.setForeground(new java.awt.Color(255, 255, 255));
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("Flight Info");

        jLabel4.setBackground(new java.awt.Color(96, 126, 137));
        jLabel4.setForeground(new java.awt.Color(96, 126, 137));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/airplane-departure.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(minimizebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fullbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(closebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(minimizebtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(title))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(closebtn)
                    .addComponent(fullbtn)))
            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(94, 127, 137));
        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setForeground(new java.awt.Color(204, 204, 204));
        jPanel2.setOpaque(false);

        jButton1.setBackground(new java.awt.Color(39, 50, 56));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Flight Info");
        jButton1.setPreferredSize(new java.awt.Dimension(96, 26));
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton1MouseExited(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(39, 50, 56));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Flight Info Edit");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton2MouseEntered(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(39, 50, 56));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Flight Creator");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton3MouseEntered(evt);
            }
        });
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(39, 50, 56));
        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("DeadLoad");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton4MouseEntered(evt);
            }
        });
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(39, 50, 56));
        jButton5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Distribution");
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton5MouseEntered(evt);
            }
        });
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(39, 50, 56));
        jButton6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("Fuel");
        jButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton6MouseEntered(evt);
            }
        });
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        more.setBackground(new java.awt.Color(39, 50, 56));
        more.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        more.setForeground(new java.awt.Color(255, 255, 255));
        more.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "more", "Change Password", "Documents", "Leteral Imbalance", "LMC" }));
        more.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                moreMouseEntered(evt);
            }
        });
        more.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moreActionPerformed(evt);
            }
        });

        logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logout.png"))); // NOI18N
        logout.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                logoutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                logoutMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                logoutMousePressed(evt);
            }
        });
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(more, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(318, 318, 318)
                .addComponent(logout, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(logout, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(more, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jLayeredPane1.setBackground(new java.awt.Color(255, 255, 255));
        jLayeredPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLayeredPane1MousePressed(evt);
            }
        });
        jLayeredPane1.setLayout(new java.awt.CardLayout());

        flightCreatorPanel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel17.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel17.setText("Date");

        jLabel18.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel18.setText("Flight No");

        jLabel19.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel19.setText("ORG");

        jLabel20.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel20.setText("DEST1");

        jLabel21.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel21.setText("DEST2");

        jLabel22.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel22.setText("DEST3");

        f_flight_no.setBackground(new java.awt.Color(204, 204, 204));
        f_flight_no.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        f_flight_no.setToolTipText("Enter Flight No");
        f_flight_no.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        f_flight_no.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                f_flight_noMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                f_flight_noMouseEntered(evt);
            }
        });
        f_flight_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                f_flight_noActionPerformed(evt);
            }
        });
        f_flight_no.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                f_flight_noKeyReleased(evt);
            }
        });

        f_org.setBackground(new java.awt.Color(204, 204, 204));
        f_org.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        f_org.setToolTipText("Enter Origin");
        f_org.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        f_org.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                f_orgMouseClicked(evt);
            }
        });
        f_org.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                f_orgKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                f_orgKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                f_orgKeyTyped(evt);
            }
        });

        f_dest1.setBackground(new java.awt.Color(204, 204, 204));
        f_dest1.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        f_dest1.setToolTipText("Enter First Destination");
        f_dest1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        f_dest1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                f_dest1MouseClicked(evt);
            }
        });
        f_dest1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                f_dest1ActionPerformed(evt);
            }
        });
        f_dest1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                f_dest1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                f_dest1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                f_dest1KeyTyped(evt);
            }
        });

        f_dest2.setBackground(new java.awt.Color(204, 204, 204));
        f_dest2.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        f_dest2.setToolTipText("Enter Second Destination");
        f_dest2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        f_dest2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                f_dest2KeyReleased(evt);
            }
        });

        f_dest3.setBackground(new java.awt.Color(204, 204, 204));
        f_dest3.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        f_dest3.setToolTipText("Enter Third Destination");
        f_dest3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        f_dest3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                f_dest3KeyReleased(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel23.setText("STD");

        jLabel24.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel24.setText("A/C TYPE");

        jLabel25.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel25.setText("REG");

        f_std.setBackground(new java.awt.Color(204, 204, 204));
        f_std.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        f_std.setToolTipText("Enter STD 24 hour Format");
        f_std.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        f_std.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                f_stdMouseClicked(evt);
            }
        });
        f_std.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                f_stdKeyReleased(evt);
            }
        });

        f_create.setBackground(new java.awt.Color(39, 50, 56));
        f_create.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        f_create.setForeground(new java.awt.Color(255, 255, 255));
        f_create.setText("Create Flight");
        f_create.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                f_createMouseReleased(evt);
            }
        });
        f_create.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                f_createActionPerformed(evt);
            }
        });

        f_ac.setBackground(new java.awt.Color(204, 204, 204));
        f_ac.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Select-", "330-200" }));

        f_reg.setBackground(new java.awt.Color(204, 204, 204));
        f_reg.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SUGCJ", "SUGCF", "SUGCE" }));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/egyptair_logo loadcontrol.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 719, Short.MAX_VALUE)
                .addGap(66, 66, 66))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout flightCreatorPanelLayout = new javax.swing.GroupLayout(flightCreatorPanel);
        flightCreatorPanel.setLayout(flightCreatorPanelLayout);
        flightCreatorPanelLayout.setHorizontalGroup(
            flightCreatorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(flightCreatorPanelLayout.createSequentialGroup()
                .addGap(143, 143, 143)
                .addGroup(flightCreatorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(flightCreatorPanelLayout.createSequentialGroup()
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(188, Short.MAX_VALUE))
                    .addGroup(flightCreatorPanelLayout.createSequentialGroup()
                        .addGroup(flightCreatorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(flightCreatorPanelLayout.createSequentialGroup()
                                .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(25, 25, 25))
                            .addGroup(flightCreatorPanelLayout.createSequentialGroup()
                                .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(23, 23, 23))
                            .addGroup(flightCreatorPanelLayout.createSequentialGroup()
                                .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(12, 12, 12))
                            .addGroup(flightCreatorPanelLayout.createSequentialGroup()
                                .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(12, 12, 12))
                            .addGroup(flightCreatorPanelLayout.createSequentialGroup()
                                .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(12, 12, 12)))
                        .addGap(25, 25, 25)
                        .addGroup(flightCreatorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(f_dest3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                            .addComponent(f_dest2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                            .addComponent(f_dest1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                            .addComponent(f_flight_no, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                            .addComponent(f_org, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                            .addComponent(f_date, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(flightCreatorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(flightCreatorPanelLayout.createSequentialGroup()
                                .addGap(110, 110, 110)
                                .addGroup(flightCreatorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(flightCreatorPanelLayout.createSequentialGroup()
                                        .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(35, 35, 35))
                                    .addGroup(flightCreatorPanelLayout.createSequentialGroup()
                                        .addGroup(flightCreatorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(flightCreatorPanelLayout.createSequentialGroup()
                                                .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(28, 28, 28))
                                            .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(74, 74, 74))))
                            .addGroup(flightCreatorPanelLayout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addComponent(f_create, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(70, 70, 70)))
                        .addGroup(flightCreatorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(f_std, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
                            .addComponent(f_ac, 0, 229, Short.MAX_VALUE)
                            .addComponent(f_reg, 0, 229, Short.MAX_VALUE))
                        .addGap(171, 171, 171))))
        );
        flightCreatorPanelLayout.setVerticalGroup(
            flightCreatorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(flightCreatorPanelLayout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(flightCreatorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(flightCreatorPanelLayout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addGroup(flightCreatorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(flightCreatorPanelLayout.createSequentialGroup()
                                .addComponent(f_std)
                                .addGap(3, 3, 3))
                            .addGroup(flightCreatorPanelLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(flightCreatorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(flightCreatorPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(f_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(flightCreatorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(flightCreatorPanelLayout.createSequentialGroup()
                        .addComponent(f_flight_no)
                        .addGap(5, 5, 5))
                    .addGroup(flightCreatorPanelLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(flightCreatorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(flightCreatorPanelLayout.createSequentialGroup()
                                .addGroup(flightCreatorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(f_ac))
                                .addGap(3, 3, 3)))))
                .addGap(18, 18, 18)
                .addGroup(flightCreatorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(flightCreatorPanelLayout.createSequentialGroup()
                        .addComponent(f_org)
                        .addGap(5, 5, 5))
                    .addGroup(flightCreatorPanelLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(flightCreatorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(flightCreatorPanelLayout.createSequentialGroup()
                                .addGroup(flightCreatorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(f_reg))
                                .addGap(3, 3, 3)))))
                .addGap(18, 18, 18)
                .addGroup(flightCreatorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(flightCreatorPanelLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(flightCreatorPanelLayout.createSequentialGroup()
                        .addComponent(f_dest1)
                        .addGap(3, 3, 3)))
                .addGap(19, 19, 19)
                .addGroup(flightCreatorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(flightCreatorPanelLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(flightCreatorPanelLayout.createSequentialGroup()
                        .addComponent(f_dest2)
                        .addGap(3, 3, 3)))
                .addGap(18, 18, 18)
                .addGroup(flightCreatorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(flightCreatorPanelLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(flightCreatorPanelLayout.createSequentialGroup()
                        .addComponent(f_dest3)
                        .addGap(3, 3, 3)))
                .addGap(45, 45, 45)
                .addComponent(f_create)
                .addGap(159, 159, 159))
        );

        jLayeredPane1.add(flightCreatorPanel, "card2");

        documentsPanel.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout documentsPanelLayout = new javax.swing.GroupLayout(documentsPanel);
        documentsPanel.setLayout(documentsPanelLayout);
        documentsPanelLayout.setHorizontalGroup(
            documentsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1122, Short.MAX_VALUE)
        );
        documentsPanelLayout.setVerticalGroup(
            documentsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 650, Short.MAX_VALUE)
        );

        jLayeredPane1.add(documentsPanel, "card2");

        leteralImbalancePanel.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout leteralImbalancePanelLayout = new javax.swing.GroupLayout(leteralImbalancePanel);
        leteralImbalancePanel.setLayout(leteralImbalancePanelLayout);
        leteralImbalancePanelLayout.setHorizontalGroup(
            leteralImbalancePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1122, Short.MAX_VALUE)
        );
        leteralImbalancePanelLayout.setVerticalGroup(
            leteralImbalancePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 650, Short.MAX_VALUE)
        );

        jLayeredPane1.add(leteralImbalancePanel, "card2");

        lmcPanel.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout lmcPanelLayout = new javax.swing.GroupLayout(lmcPanel);
        lmcPanel.setLayout(lmcPanelLayout);
        lmcPanelLayout.setHorizontalGroup(
            lmcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1122, Short.MAX_VALUE)
        );
        lmcPanelLayout.setVerticalGroup(
            lmcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 650, Short.MAX_VALUE)
        );

        jLayeredPane1.add(lmcPanel, "card2");

        selectFlightPanel.setBackground(new java.awt.Color(255, 255, 255));

        check1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        check1.setText("MS555 01JAN CAL-OXT-MXP");
        check1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                check1ActionPerformed(evt);
            }
        });

        check2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        check2.setText("MS3333 02JAN MXP-OXT-CAL");

        check3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        check3.setText("MS5975 13FEB JNB-CAL");
        check3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                check3ActionPerformed(evt);
            }
        });

        check4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        check4.setText("MS556 01JAN CAL-JNB");
        check4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                check4ActionPerformed(evt);
            }
        });

        check5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        check5.setText("MS555 01JAN CAL-OXT-MXP");
        check5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                check5ActionPerformed(evt);
            }
        });

        check6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        check6.setText("MS3333 02JAN MXP-OXT-CAL");

        check7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        check7.setText("MS5975 13FEB JNB-CAL");
        check7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                check7ActionPerformed(evt);
            }
        });

        check8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        check8.setText("MS556 01JAN CAL-JNB");
        check8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                check8ActionPerformed(evt);
            }
        });

        check9.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        check9.setText("MS555 01JAN CAL-OXT-MXP");
        check9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                check9ActionPerformed(evt);
            }
        });

        check10.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        check10.setText("MS3333 02JAN MXP-OXT-CAL");

        check11.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        check11.setText("MS5975 13FEB JNB-CAL");
        check11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                check11ActionPerformed(evt);
            }
        });

        check12.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        check12.setText("MS556 01JAN CAL-JNB");
        check12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                check12ActionPerformed(evt);
            }
        });

        check13.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        check13.setText("MS555 01JAN CAL-OXT-MXP");
        check13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                check13ActionPerformed(evt);
            }
        });

        check14.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        check14.setText("MS5975 13FEB JNB-CAL");
        check14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                check14ActionPerformed(evt);
            }
        });

        check15.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        check15.setText("MS3333 02JAN MXP-OXT-CAL");

        check16.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        check16.setText("MS556 01JAN CAL-JNB");
        check16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                check16ActionPerformed(evt);
            }
        });

        check17.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        check17.setText("MS5975 13FEB JNB-CAL");
        check17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                check17ActionPerformed(evt);
            }
        });

        check18.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        check18.setText("MS555 01JAN CAL-OXT-MXP");
        check18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                check18ActionPerformed(evt);
            }
        });

        check19.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        check19.setText("MS3333 02JAN MXP-OXT-CAL");

        check20.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        check20.setText("MS5975 13FEB JNB-CAL");
        check20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                check20ActionPerformed(evt);
            }
        });

        check21.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        check21.setText("MS556 01JAN CAL-JNB");
        check21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                check21ActionPerformed(evt);
            }
        });

        check22.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        check22.setText("MS556 01JAN CAL-JNB");
        check22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                check22ActionPerformed(evt);
            }
        });

        check23.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        check23.setText("MS555 01JAN CAL-OXT-MXP");
        check23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                check23ActionPerformed(evt);
            }
        });

        check24.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        check24.setText("MS3333 02JAN MXP-OXT-CAL");

        check25.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        check25.setText("MS556 01JAN CAL-JNB");
        check25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                check25ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(check25)
                    .addComponent(check16)
                    .addComponent(check14)
                    .addComponent(check24)
                    .addComponent(check23)
                    .addComponent(check22)
                    .addComponent(check20)
                    .addComponent(check19)
                    .addComponent(check18)
                    .addComponent(check21)
                    .addComponent(check17)
                    .addComponent(check15)
                    .addComponent(check13)
                    .addComponent(check12)
                    .addComponent(check11)
                    .addComponent(check10)
                    .addComponent(check9)
                    .addComponent(check8)
                    .addComponent(check7)
                    .addComponent(check4)
                    .addComponent(check3)
                    .addComponent(check2)
                    .addComponent(check1)
                    .addComponent(check6)
                    .addComponent(check5))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(check1)
                .addGap(18, 18, 18)
                .addComponent(check2)
                .addGap(18, 18, 18)
                .addComponent(check3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(check4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(check5)
                .addGap(18, 18, 18)
                .addComponent(check6)
                .addGap(18, 18, 18)
                .addComponent(check7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(check8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(check9)
                .addGap(18, 18, 18)
                .addComponent(check10)
                .addGap(18, 18, 18)
                .addComponent(check11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(check12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(check13)
                .addGap(18, 18, 18)
                .addComponent(check15)
                .addGap(18, 18, 18)
                .addComponent(check17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(check21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(check18)
                .addGap(18, 18, 18)
                .addComponent(check19)
                .addGap(18, 18, 18)
                .addComponent(check20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(check22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(check23)
                .addGap(18, 18, 18)
                .addComponent(check24)
                .addGap(18, 18, 18)
                .addComponent(check14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(check16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(check25)
                .addContainerGap())
        );

        jScrollPane8.setViewportView(jPanel11);

        jLabel40.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel40.setText("Select Flight");

        jButton14.setBackground(new java.awt.Color(39, 50, 56));
        jButton14.setForeground(new java.awt.Color(255, 255, 255));
        jButton14.setText("Load Flight");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        unload.setBackground(new java.awt.Color(39, 50, 56));
        unload.setForeground(new java.awt.Color(255, 255, 255));
        unload.setText("Unload Flight");
        unload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unloadActionPerformed(evt);
            }
        });

        jButton28.setBackground(new java.awt.Color(39, 50, 56));
        jButton28.setForeground(new java.awt.Color(255, 255, 255));
        jButton28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/filled-trash.png"))); // NOI18N
        jButton28.setText("Delete");
        jButton28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton28ActionPerformed(evt);
            }
        });

        jButton16.setBackground(new java.awt.Color(39, 50, 56));
        jButton16.setForeground(new java.awt.Color(255, 255, 255));
        jButton16.setText("Import Flight");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(317, 317, 317)
                        .addComponent(jLabel40))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jButton28, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(unload)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton16)
                                .addGap(1, 1, 1))
                            .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 720, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(62, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel40)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton14)
                    .addComponent(unload)
                    .addComponent(jButton28, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton16))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout selectFlightPanelLayout = new javax.swing.GroupLayout(selectFlightPanel);
        selectFlightPanel.setLayout(selectFlightPanelLayout);
        selectFlightPanelLayout.setHorizontalGroup(
            selectFlightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(selectFlightPanelLayout.createSequentialGroup()
                .addGap(138, 138, 138)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(157, Short.MAX_VALUE))
        );
        selectFlightPanelLayout.setVerticalGroup(
            selectFlightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(selectFlightPanelLayout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(186, Short.MAX_VALUE))
        );

        jLayeredPane1.add(selectFlightPanel, "card2");

        flighteditPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel74.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel74.setText("Date");

        jLabel75.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel75.setText("Flight No");

        jLabel76.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel76.setText("ORG");

        jLabel118.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel118.setText("DEST1");

        jLabel119.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel119.setText("DEST2");

        jLabel120.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel120.setText("DEST3");

        jTextField10.setBackground(new java.awt.Color(204, 204, 204));
        jTextField10.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jTextField10.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTextField10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField10ActionPerformed(evt);
            }
        });

        jTextField14.setBackground(new java.awt.Color(204, 204, 204));
        jTextField14.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jTextField14.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jTextField16.setBackground(new java.awt.Color(204, 204, 204));
        jTextField16.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jTextField16.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTextField16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField16ActionPerformed(evt);
            }
        });

        jTextField17.setBackground(new java.awt.Color(204, 204, 204));
        jTextField17.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jTextField17.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jTextField18.setBackground(new java.awt.Color(204, 204, 204));
        jTextField18.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jTextField18.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel121.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel121.setText("STD");

        jLabel122.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel122.setText("A/C TYPE");

        jLabel123.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel123.setText("REG");

        jTextField19.setBackground(new java.awt.Color(204, 204, 204));
        jTextField19.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jTextField19.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButton22.setBackground(new java.awt.Color(39, 50, 56));
        jButton22.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton22.setForeground(new java.awt.Color(255, 255, 255));
        jButton22.setText("Save");
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });

        jButton23.setBackground(new java.awt.Color(39, 50, 56));
        jButton23.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton23.setForeground(new java.awt.Color(255, 255, 255));
        jButton23.setText("Load");

        jButton24.setBackground(new java.awt.Color(39, 50, 56));
        jButton24.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton24.setForeground(new java.awt.Color(255, 255, 255));
        jButton24.setText("Delete");
        jButton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton24ActionPerformed(evt);
            }
        });

        jComboBox3.setBackground(new java.awt.Color(204, 204, 204));
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Select-" }));

        jComboBox4.setBackground(new java.awt.Color(204, 204, 204));
        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Select-" }));

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));

        jLabel124.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/egyptair_logo loadcontrol.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel124, javax.swing.GroupLayout.PREFERRED_SIZE, 719, Short.MAX_VALUE)
                .addGap(66, 66, 66))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addComponent(jLabel124, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        jComboBox8.setBackground(new java.awt.Color(204, 204, 204));
        jComboBox8.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jComboBox8.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Select-" }));

        jLabel125.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel125.setText("CREW");

        jTextField1.setEditable(false);
        jTextField1.setBackground(new java.awt.Color(204, 204, 204));
        jTextField1.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jTextField1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTextField1MousePressed(evt);
            }
        });
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jTextField20.setEditable(false);
        jTextField20.setBackground(new java.awt.Color(204, 204, 204));
        jTextField20.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jTextField20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTextField20MousePressed(evt);
            }
        });
        jTextField20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField20ActionPerformed(evt);
            }
        });

        jLabel126.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel126.setText("DOW");

        jLabel127.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel127.setText("DOI");

        jLabel128.setForeground(new java.awt.Color(204, 0, 0));
        jLabel128.setText("Mark the check box to edit the DOW & DOI");

        jCheckBox5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout flighteditPanel1Layout = new javax.swing.GroupLayout(flighteditPanel1);
        flighteditPanel1.setLayout(flighteditPanel1Layout);
        flighteditPanel1Layout.setHorizontalGroup(
            flighteditPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(flighteditPanel1Layout.createSequentialGroup()
                .addGap(143, 143, 143)
                .addGroup(flighteditPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(flighteditPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(flighteditPanel1Layout.createSequentialGroup()
                        .addGroup(flighteditPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(flighteditPanel1Layout.createSequentialGroup()
                                .addGroup(flighteditPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel75, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(flighteditPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel74, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(25, 25, 25))
                                    .addGroup(flighteditPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel76, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(23, 23, 23))
                                    .addGroup(flighteditPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel118, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(12, 12, 12))
                                    .addGroup(flighteditPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel119, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(12, 12, 12))
                                    .addGroup(flighteditPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel120, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(12, 12, 12)))
                                .addGap(25, 25, 25)
                                .addGroup(flighteditPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTextField18, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField17, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField16, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField14, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, flighteditPanel1Layout.createSequentialGroup()
                                        .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(flighteditPanel1Layout.createSequentialGroup()
                                .addGap(159, 159, 159)
                                .addComponent(jButton22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(flighteditPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(flighteditPanel1Layout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addComponent(jButton23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(70, 70, 70))
                            .addGroup(flighteditPanel1Layout.createSequentialGroup()
                                .addGap(110, 110, 110)
                                .addGroup(flighteditPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(flighteditPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel123, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(35, 35, 35))
                                    .addGroup(flighteditPanel1Layout.createSequentialGroup()
                                        .addGroup(flighteditPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(flighteditPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel122, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(28, 28, 28))
                                            .addComponent(jLabel121, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(74, 74, 74))
                                    .addGroup(flighteditPanel1Layout.createSequentialGroup()
                                        .addGroup(flighteditPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(flighteditPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel126, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(5, 5, 5))
                                            .addComponent(jLabel125, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(flighteditPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel127, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(12, 12, 12)))
                                        .addGap(120, 120, 120)))))
                        .addGroup(flighteditPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField19, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                            .addComponent(jComboBox3, 0, 214, Short.MAX_VALUE)
                            .addComponent(jComboBox4, 0, 214, Short.MAX_VALUE)
                            .addGroup(flighteditPanel1Layout.createSequentialGroup()
                                .addComponent(jButton24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(88, 88, 88))
                            .addComponent(jComboBox8, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField1)
                            .addComponent(jTextField20))
                        .addGap(171, 171, 171))
                    .addGroup(flighteditPanel1Layout.createSequentialGroup()
                        .addGap(625, 625, 625)
                        .addComponent(jLabel128, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
                        .addGap(27, 27, 27)
                        .addComponent(jCheckBox5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(50, 50, 50))))
        );
        flighteditPanel1Layout.setVerticalGroup(
            flighteditPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(flighteditPanel1Layout.createSequentialGroup()
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addGroup(flighteditPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(flighteditPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel128, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jCheckBox5))
                .addGroup(flighteditPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(flighteditPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(flighteditPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(flighteditPanel1Layout.createSequentialGroup()
                                .addComponent(jTextField19)
                                .addGap(3, 3, 3))
                            .addGroup(flighteditPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(flighteditPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel121, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel74, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(flighteditPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(flighteditPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(flighteditPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField10)
                        .addGap(5, 5, 5))
                    .addGroup(flighteditPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(flighteditPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel75, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(flighteditPanel1Layout.createSequentialGroup()
                                .addGroup(flighteditPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel122, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jComboBox3))
                                .addGap(3, 3, 3)))))
                .addGap(18, 18, 18)
                .addGroup(flighteditPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(flighteditPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField14)
                        .addGap(5, 5, 5))
                    .addGroup(flighteditPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(flighteditPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel76, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(flighteditPanel1Layout.createSequentialGroup()
                                .addGroup(flighteditPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel123, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jComboBox4))
                                .addGap(3, 3, 3)))))
                .addGap(18, 18, 18)
                .addGroup(flighteditPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(flighteditPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel118, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, flighteditPanel1Layout.createSequentialGroup()
                        .addGroup(flighteditPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, flighteditPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel125, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jComboBox8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField16))
                        .addGap(3, 3, 3)))
                .addGroup(flighteditPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(flighteditPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(flighteditPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(flighteditPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel119, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(flighteditPanel1Layout.createSequentialGroup()
                                .addGroup(flighteditPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField17)
                                    .addComponent(jTextField1))
                                .addGap(3, 3, 3))))
                    .addGroup(flighteditPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel126, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(8, 8, 8)))
                .addGap(18, 18, 18)
                .addGroup(flighteditPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(flighteditPanel1Layout.createSequentialGroup()
                        .addGroup(flighteditPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(flighteditPanel1Layout.createSequentialGroup()
                                .addGroup(flighteditPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(flighteditPanel1Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jLabel120, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(flighteditPanel1Layout.createSequentialGroup()
                                        .addComponent(jTextField18)
                                        .addGap(3, 3, 3)))
                                .addGap(45, 45, 45))
                            .addGroup(flighteditPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel127, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(54, 54, 54)))
                        .addGroup(flighteditPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(flighteditPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButton22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(159, 159, 159))
                    .addGroup(flighteditPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField20)
                        .addGap(230, 230, 230))))
        );

        jLayeredPane1.add(flighteditPanel1, "card2");

        deadloadPanel.setBackground(new java.awt.Color(255, 255, 255));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ULD/BULK", "Gross", "Net Weight", "TARE", "Height", "Dest", "Commodity", "Location", "DG/SL", "Overhang", "SXS", "Onward Dest", "Description"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.setToolTipText("bold");
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(20);
            jTable1.getColumnModel().getColumn(0).setHeaderValue("ULD/BULK");
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(10);
            jTable1.getColumnModel().getColumn(1).setHeaderValue("Gross");
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(35);
            jTable1.getColumnModel().getColumn(2).setHeaderValue("Net Weight");
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(10);
            jTable1.getColumnModel().getColumn(3).setHeaderValue("TARE");
            jTable1.getColumnModel().getColumn(4).setResizable(false);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(30);
            jTable1.getColumnModel().getColumn(4).setHeaderValue("Height");
            jTable1.getColumnModel().getColumn(5).setResizable(false);
            jTable1.getColumnModel().getColumn(5).setPreferredWidth(10);
            jTable1.getColumnModel().getColumn(5).setHeaderValue("Dest");
            jTable1.getColumnModel().getColumn(6).setResizable(false);
            jTable1.getColumnModel().getColumn(6).setPreferredWidth(40);
            jTable1.getColumnModel().getColumn(6).setHeaderValue("Commodity");
            jTable1.getColumnModel().getColumn(7).setResizable(false);
            jTable1.getColumnModel().getColumn(7).setPreferredWidth(40);
            jTable1.getColumnModel().getColumn(7).setHeaderValue("Location");
            jTable1.getColumnModel().getColumn(8).setResizable(false);
            jTable1.getColumnModel().getColumn(8).setPreferredWidth(20);
            jTable1.getColumnModel().getColumn(8).setHeaderValue("DG/SL");
            jTable1.getColumnModel().getColumn(9).setResizable(false);
            jTable1.getColumnModel().getColumn(9).setPreferredWidth(40);
            jTable1.getColumnModel().getColumn(9).setHeaderValue("Overhang");
            jTable1.getColumnModel().getColumn(10).setResizable(false);
            jTable1.getColumnModel().getColumn(10).setPreferredWidth(20);
            jTable1.getColumnModel().getColumn(10).setHeaderValue("SXS");
            jTable1.getColumnModel().getColumn(11).setResizable(false);
            jTable1.getColumnModel().getColumn(11).setHeaderValue("Onward Dest");
            jTable1.getColumnModel().getColumn(12).setResizable(false);
            jTable1.getColumnModel().getColumn(12).setPreferredWidth(150);
            jTable1.getColumnModel().getColumn(12).setHeaderValue("Description");
        }

        deadload1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ULD/BULK", "Gross", "Net Weight", "TARE", "Height", "Dest", "Commodity", "Location", "DG/SL", "Overhang", "SXS", "Onward Dest", "Description"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        deadload1.setToolTipText("");
        deadload1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        deadload1.setSelectionBackground(new java.awt.Color(255, 102, 0));
        deadload1.getTableHeader().setReorderingAllowed(false);
        deadload1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                deadload1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                deadload1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                deadload1KeyTyped(evt);
            }
        });
        jScrollPane3.setViewportView(deadload1);
        deadload1.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (deadload1.getColumnModel().getColumnCount() > 0) {
            deadload1.getColumnModel().getColumn(0).setResizable(false);
            deadload1.getColumnModel().getColumn(0).setPreferredWidth(20);
            deadload1.getColumnModel().getColumn(1).setResizable(false);
            deadload1.getColumnModel().getColumn(1).setPreferredWidth(10);
            deadload1.getColumnModel().getColumn(2).setResizable(false);
            deadload1.getColumnModel().getColumn(2).setPreferredWidth(35);
            deadload1.getColumnModel().getColumn(3).setResizable(false);
            deadload1.getColumnModel().getColumn(3).setPreferredWidth(10);
            deadload1.getColumnModel().getColumn(4).setResizable(false);
            deadload1.getColumnModel().getColumn(4).setPreferredWidth(30);
            deadload1.getColumnModel().getColumn(5).setResizable(false);
            deadload1.getColumnModel().getColumn(5).setPreferredWidth(10);
            deadload1.getColumnModel().getColumn(6).setResizable(false);
            deadload1.getColumnModel().getColumn(6).setPreferredWidth(40);
            deadload1.getColumnModel().getColumn(7).setResizable(false);
            deadload1.getColumnModel().getColumn(7).setPreferredWidth(40);
            deadload1.getColumnModel().getColumn(8).setResizable(false);
            deadload1.getColumnModel().getColumn(8).setPreferredWidth(20);
            deadload1.getColumnModel().getColumn(9).setResizable(false);
            deadload1.getColumnModel().getColumn(9).setPreferredWidth(40);
            deadload1.getColumnModel().getColumn(10).setResizable(false);
            deadload1.getColumnModel().getColumn(10).setPreferredWidth(20);
            deadload1.getColumnModel().getColumn(11).setResizable(false);
            deadload1.getColumnModel().getColumn(12).setResizable(false);
            deadload1.getColumnModel().getColumn(12).setPreferredWidth(150);
        }

        jButton17.setBackground(new java.awt.Color(39, 50, 56));
        jButton17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton17.setForeground(new java.awt.Color(255, 255, 255));
        jButton17.setText("Create Load");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        jButton18.setBackground(new java.awt.Color(39, 50, 56));
        jButton18.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton18.setForeground(new java.awt.Color(255, 255, 255));
        jButton18.setText("Delete Load");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        jButton20.setBackground(new java.awt.Color(39, 50, 56));
        jButton20.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton20.setForeground(new java.awt.Color(255, 255, 255));
        jButton20.setText("OFFLOAD");
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });

        jButton19.setBackground(new java.awt.Color(39, 50, 56));
        jButton19.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton19.setForeground(new java.awt.Color(255, 255, 255));
        jButton19.setText("RELOAD");
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });

        apply.setBackground(new java.awt.Color(39, 50, 56));
        apply.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        apply.setForeground(new java.awt.Color(255, 255, 255));
        apply.setText("APPLY");
        apply.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                applyActionPerformed(evt);
            }
        });

        jLabel129.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel129.setText("DEADLOAD LIST");

        jLabel130.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel130.setText("OFFLOAD LIST");

        jLabel131.setText("Total ULDs :");

        jLabel132.setText("6");

        jLabel133.setText("Total Bulk :");

        jLabel134.setText("550");

        jLabel135.setText("Total Payload :");

        jLabel136.setText("18910");

        jLabel137.setText("Total ULDs :");

        jLabel138.setText("1");

        jLabel139.setText("Total Bulk :");

        jLabel140.setText("50");

        jLabel141.setText("Total OffLoad :");

        jLabel142.setText("Total Payload include Offload :");

        jLabel143.setText("1050");

        jLabel144.setText("20050");

        javax.swing.GroupLayout deadloadPanelLayout = new javax.swing.GroupLayout(deadloadPanel);
        deadloadPanel.setLayout(deadloadPanelLayout);
        deadloadPanelLayout.setHorizontalGroup(
            deadloadPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(deadloadPanelLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jButton17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(26, 26, 26)
                .addComponent(jButton18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(710, 710, 710)
                .addComponent(jButton20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(21, 21, 21))
            .addComponent(jScrollPane3)
            .addGroup(deadloadPanelLayout.createSequentialGroup()
                .addGroup(deadloadPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(deadloadPanelLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel129, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(669, 669, 669))
                    .addGroup(deadloadPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel130, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(696, 696, 696))
                    .addGroup(deadloadPanelLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel131, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel132, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(72, 72, 72)
                        .addComponent(jLabel133, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel134, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(47, 47, 47)
                        .addComponent(jLabel135, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(32, 32, 32)
                        .addComponent(jLabel136, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(292, 292, 292))
                    .addGroup(deadloadPanelLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel137, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel138, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(70, 70, 70)
                        .addComponent(jLabel139, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel140, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(62, 62, 62)
                        .addComponent(jLabel141, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(34, 34, 34)
                        .addComponent(jLabel143, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(92, 92, 92)
                        .addComponent(jLabel142, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel144, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(317, 317, 317))
            .addGroup(deadloadPanelLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jButton19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(882, 882, 882)
                .addComponent(apply, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(19, 19, 19))
        );
        deadloadPanelLayout.setVerticalGroup(
            deadloadPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(deadloadPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel129)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(deadloadPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel131, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel132, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel133, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel134, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel135, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel136, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(deadloadPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel130)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(deadloadPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel137, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel138, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel139, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel140, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel141, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel142, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel143, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel144, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(deadloadPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(apply, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(139, 139, 139))
        );

        jLayeredPane1.add(deadloadPanel, "card2");

        fuelPanel.setBackground(new java.awt.Color(255, 255, 255));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Kg", "0.760", "0.765", "0.770", "0.775", "0.780", "0.785", "0.790", "0.795", "0.800", "0.805", "0.810", "0.815", "0.820", "0.825", "0.830"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTable2.setGridColor(new java.awt.Color(96, 126, 137));
        jTable2.setSelectionBackground(new java.awt.Color(96, 126, 137));
        jTable2.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jTable2.setShowGrid(true);
        jTable2.getTableHeader().setResizingAllowed(false);
        jTable2.getTableHeader().setReorderingAllowed(false);
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTable2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jTable2MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTable2MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTable2MouseReleased(evt);
            }
        });
        jTable2.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                jTable2ComponentResized(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(0).setResizable(false);
            jTable2.getColumnModel().getColumn(0).setPreferredWidth(150);
            jTable2.getColumnModel().getColumn(1).setResizable(false);
            jTable2.getColumnModel().getColumn(1).setPreferredWidth(60);
            jTable2.getColumnModel().getColumn(2).setResizable(false);
            jTable2.getColumnModel().getColumn(2).setPreferredWidth(60);
            jTable2.getColumnModel().getColumn(3).setResizable(false);
            jTable2.getColumnModel().getColumn(3).setPreferredWidth(60);
            jTable2.getColumnModel().getColumn(4).setResizable(false);
            jTable2.getColumnModel().getColumn(4).setPreferredWidth(60);
            jTable2.getColumnModel().getColumn(5).setResizable(false);
            jTable2.getColumnModel().getColumn(5).setPreferredWidth(60);
            jTable2.getColumnModel().getColumn(6).setResizable(false);
            jTable2.getColumnModel().getColumn(6).setPreferredWidth(60);
            jTable2.getColumnModel().getColumn(7).setResizable(false);
            jTable2.getColumnModel().getColumn(7).setPreferredWidth(60);
            jTable2.getColumnModel().getColumn(8).setResizable(false);
            jTable2.getColumnModel().getColumn(8).setPreferredWidth(60);
            jTable2.getColumnModel().getColumn(9).setResizable(false);
            jTable2.getColumnModel().getColumn(9).setPreferredWidth(60);
            jTable2.getColumnModel().getColumn(10).setResizable(false);
            jTable2.getColumnModel().getColumn(10).setPreferredWidth(60);
            jTable2.getColumnModel().getColumn(11).setResizable(false);
            jTable2.getColumnModel().getColumn(11).setPreferredWidth(60);
            jTable2.getColumnModel().getColumn(12).setResizable(false);
            jTable2.getColumnModel().getColumn(12).setPreferredWidth(60);
            jTable2.getColumnModel().getColumn(13).setResizable(false);
            jTable2.getColumnModel().getColumn(13).setPreferredWidth(60);
            jTable2.getColumnModel().getColumn(14).setResizable(false);
            jTable2.getColumnModel().getColumn(14).setPreferredWidth(60);
            jTable2.getColumnModel().getColumn(15).setResizable(false);
            jTable2.getColumnModel().getColumn(15).setPreferredWidth(60);
        }

        jPanel17.setBackground(new java.awt.Color(255, 255, 255));

        jLabel145.setText("Fuel Distribution");

        jLabel146.setText("Block Fuel");

        jLabel147.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel147.setForeground(new java.awt.Color(102, 102, 102));
        jLabel147.setText("(Including Unusable)");

        jLabel148.setText("Taxi Fuel");

        jLabel149.setText("Trip Fuel");

        jLabel150.setText("Unusable Fuel");

        jLabel151.setText("Density");

        fuel_distri_combo.setBackground(new java.awt.Color(204, 204, 204));
        fuel_distri_combo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Standard", "Manual" }));

        block_f.setBackground(new java.awt.Color(204, 204, 204));
        block_f.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                block_fActionPerformed(evt);
            }
        });
        block_f.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                block_fKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                block_fKeyTyped(evt);
            }
        });

        taxi_f.setBackground(new java.awt.Color(204, 204, 204));

        trip_f.setBackground(new java.awt.Color(204, 204, 204));
        trip_f.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                trip_fMouseClicked(evt);
            }
        });
        trip_f.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trip_fActionPerformed(evt);
            }
        });
        trip_f.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                trip_fKeyReleased(evt);
            }
        });

        unusable_f.setBackground(new java.awt.Color(204, 204, 204));
        unusable_f.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                unusable_fMouseClicked(evt);
            }
        });
        unusable_f.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                unusable_fKeyReleased(evt);
            }
        });

        density_combo.setBackground(new java.awt.Color(204, 204, 204));
        density_combo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                density_comboMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                density_comboMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                density_comboMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                density_comboMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                density_comboMouseReleased(evt);
            }
        });
        density_combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                density_comboActionPerformed(evt);
            }
        });

        jButton25.setBackground(new java.awt.Color(39, 50, 56));
        jButton25.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton25.setForeground(new java.awt.Color(255, 255, 255));
        jButton25.setText("Apply");
        jButton25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton25ActionPerformed(evt);
            }
        });

        trip_i.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        unusable_i.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        block_i.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel147)
                            .addGroup(jPanel17Layout.createSequentialGroup()
                                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel145, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel146, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel149, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel148, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel17Layout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel151, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel150, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(28, 28, 28)
                                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(fuel_distri_combo, 0, 111, Short.MAX_VALUE)
                                    .addComponent(block_f, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                                    .addComponent(taxi_f, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                                    .addComponent(trip_f, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                                    .addComponent(unusable_f, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                                    .addComponent(density_combo, 0, 111, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(block_i, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(trip_i, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                                    .addComponent(unusable_i, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(jButton25)))
                .addGap(14, 14, 14))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel145))
                    .addComponent(fuel_distri_combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel146)
                    .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(block_f, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(block_i, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(5, 5, 5)
                .addComponent(jLabel147, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel148)
                    .addComponent(taxi_f, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(trip_i, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel149))
                    .addComponent(trip_f))
                .addGap(23, 23, 23)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel150))
                    .addComponent(unusable_f)
                    .addComponent(unusable_i, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel151))
                    .addComponent(density_combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addComponent(jButton25, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel18.setBackground(new java.awt.Color(96, 126, 137));
        jPanel18.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel153.setText("Weight");
        jLabel153.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel154.setText("Fuel Density (kg/l)");

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addComponent(jLabel153, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(273, 273, 273)
                .addComponent(jLabel154)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel153, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addComponent(jLabel154))
        );

        jPanel19.setBackground(new java.awt.Color(96, 126, 137));
        jPanel19.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel152.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel152.setText("STANDARD INDEX FUEL TABLE");

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(241, 241, 241)
                .addComponent(jLabel152, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
                .addGap(240, 240, 240))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel152, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout fuelPanelLayout = new javax.swing.GroupLayout(fuelPanel);
        fuelPanel.setLayout(fuelPanelLayout);
        fuelPanelLayout.setHorizontalGroup(
            fuelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fuelPanelLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(fuelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        fuelPanelLayout.setVerticalGroup(
            fuelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fuelPanelLayout.createSequentialGroup()
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(fuelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(fuelPanelLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(303, 303, 303))
                    .addGroup(fuelPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2)
                        .addGap(66, 66, 66))))
        );

        jLayeredPane1.add(fuelPanel, "card2");

        flightInfoPanel.setBackground(new java.awt.Color(255, 255, 255));
        flightInfoPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                flightInfoPanelMousePressed(evt);
            }
        });

        jPanel10.setBackground(new java.awt.Color(96, 126, 137));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Weight");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel10.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(202, 22, 85, 18));

        jLabel64.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel64.setText("Maximun");
        jLabel64.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel10.add(jLabel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(292, 22, 85, 18));

        jLabel65.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel65.setText("DOW");
        jLabel65.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel10.add(jLabel65, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 58, 85, 18));

        jLabel66.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel66.setText("FWD");
        jLabel66.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel10.add(jLabel66, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 94, 85, 18));

        jLabel67.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel67.setText("CTR");
        jLabel67.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel10.add(jLabel67, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 130, 85, 18));

        jLabel68.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel68.setText("AFT");
        jLabel68.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel10.add(jLabel68, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 166, 85, 18));
        jPanel10.add(dow, new org.netbeans.lib.awtextra.AbsoluteConstraints(202, 58, 85, 18));
        jPanel10.add(w_fwd, new org.netbeans.lib.awtextra.AbsoluteConstraints(202, 94, 85, 18));
        jPanel10.add(w_ctr, new org.netbeans.lib.awtextra.AbsoluteConstraints(202, 130, 85, 18));
        jPanel10.add(w_aft, new org.netbeans.lib.awtextra.AbsoluteConstraints(202, 166, 85, 18));

        jLabel77.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel77.setText("Index");
        jLabel77.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel10.add(jLabel77, new org.netbeans.lib.awtextra.AbsoluteConstraints(388, 22, 85, 18));
        jPanel10.add(doi, new org.netbeans.lib.awtextra.AbsoluteConstraints(388, 58, 85, 18));
        jPanel10.add(i_fwd, new org.netbeans.lib.awtextra.AbsoluteConstraints(388, 94, 85, 18));
        jPanel10.add(i_ctr, new org.netbeans.lib.awtextra.AbsoluteConstraints(388, 130, 85, 18));
        jPanel10.add(i_aft, new org.netbeans.lib.awtextra.AbsoluteConstraints(388, 166, 85, 18));

        jPanel13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel82.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel82.setText("ZFW");
        jLabel82.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel83.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel83.setText("ZEMAC");
        jLabel83.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        p_zfw.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        p_zemac.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel82, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel83, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel84, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel85, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(p_zemac, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
                    .addComponent(p_zfw, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel88, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel82, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel84, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(p_zfw, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel88, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel83, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(p_zemac, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel85, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel10.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 190, 475, 60));

        jLabel89.setText("UNUSEABLE FULE");
        jLabel89.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel10.add(jLabel89, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 264, 110, -1));

        jLabel90.setText("ZFW + UNUSEABLE");
        jLabel90.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel10.add(jLabel90, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 288, 110, -1));

        jLabel91.setText("FUEL ON BOARD");
        jLabel91.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel10.add(jLabel91, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 324, 110, -1));

        jLabel92.setText("TAXI");
        jLabel92.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel10.add(jLabel92, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 351, 110, -1));
        jPanel10.add(w_f_board, new org.netbeans.lib.awtextra.AbsoluteConstraints(202, 324, 85, 18));
        jPanel10.add(w_taxi, new org.netbeans.lib.awtextra.AbsoluteConstraints(202, 351, 85, 18));
        jPanel10.add(i_f_board, new org.netbeans.lib.awtextra.AbsoluteConstraints(388, 324, 85, 18));

        jPanel14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel96.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel96.setText("TOW");
        jLabel96.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel97.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel97.setText("TOMAC");
        jLabel97.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        p_tow.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel96, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel97, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE))
                .addGap(37, 37, 37)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel99, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel98, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(p_tow, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel102, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                .addGap(23, 23, 23))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel98, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel96, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(p_tow, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel102, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel97, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel99, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel10.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 375, 475, 60));

        jPanel15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel101.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel101.setText("PAYLOAD");
        jLabel101.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel103.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel103.setText("UNDERLOAD");
        jLabel103.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel101, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel103, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel104, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel105, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(107, 107, 107)
                .addComponent(jLabel107, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel104, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel101, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel107, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel103, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel105, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel10.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 546, 470, -1));

        jLabel106.setText("TRIP FUEl");
        jLabel106.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel10.add(jLabel106, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 449, 110, -1));

        jLabel108.setText("LANDING FUEL");
        jLabel108.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel10.add(jLabel108, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 473, 110, -1));

        jLabel109.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel109.setText("(with Unusable)");
        jLabel109.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel10.add(jLabel109, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 497, 110, 13));

        jLabel110.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel110.setText("LDW");
        jLabel110.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel10.add(jLabel110, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 522, 110, -1));
        jPanel10.add(w_trip, new org.netbeans.lib.awtextra.AbsoluteConstraints(202, 449, 85, 18));
        jPanel10.add(w_landing, new org.netbeans.lib.awtextra.AbsoluteConstraints(202, 470, 85, 18));
        jPanel10.add(i_landing, new org.netbeans.lib.awtextra.AbsoluteConstraints(388, 473, 85, 18));
        jPanel10.add(i_trip, new org.netbeans.lib.awtextra.AbsoluteConstraints(388, 449, 85, 18));
        jPanel10.add(jLabel115, new org.netbeans.lib.awtextra.AbsoluteConstraints(202, 522, 85, 18));

        p_ldw.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jPanel10.add(p_ldw, new org.netbeans.lib.awtextra.AbsoluteConstraints(292, 522, 85, 18));
        jPanel10.add(jLabel117, new org.netbeans.lib.awtextra.AbsoluteConstraints(388, 522, 85, 18));
        jPanel10.add(w_unusable, new org.netbeans.lib.awtextra.AbsoluteConstraints(202, 264, 85, 18));
        jPanel10.add(i_unusable, new org.netbeans.lib.awtextra.AbsoluteConstraints(388, 264, 85, 18));

        jButton10.setBackground(new java.awt.Color(96, 126, 137));
        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/circle.png"))); // NOI18N

        jButton8.setBackground(new java.awt.Color(96, 126, 137));
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/circle.png"))); // NOI18N

        jLabel34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/chat.png"))); // NOI18N

        jLabel41.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel41.setText("Registration :");

        jLabel42.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel42.setText("Crew :");

        jLabel43.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel43.setText("A/C Type :");

        jLabel44.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel44.setText("Route :");

        jLabel45.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel45.setText(" Date :");

        jLabel46.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel46.setText("STD :");

        ac_type.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        route.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        date.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        std.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        crewCombo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                crewComboMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                crewComboMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                crewComboMouseReleased(evt);
            }
        });
        crewCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crewComboActionPerformed(evt);
            }
        });

        regCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regComboActionPerformed(evt);
            }
        });

        jButton9.setBackground(new java.awt.Color(39, 50, 56));
        jButton9.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        jButton9.setForeground(new java.awt.Color(255, 255, 255));
        jButton9.setText("Update");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/airplane-departure (1).png"))); // NOI18N

        javax.swing.GroupLayout flightInfoPanelLayout = new javax.swing.GroupLayout(flightInfoPanel);
        flightInfoPanel.setLayout(flightInfoPanelLayout);
        flightInfoPanelLayout.setHorizontalGroup(
            flightInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(flightInfoPanelLayout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addGroup(flightInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(flightInfoPanelLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(flightInfoPanelLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(flightInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addGroup(flightInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(regCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(crewCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(flightInfoPanelLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70)
                        .addComponent(ac_type, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(flightInfoPanelLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(90, 90, 90)
                        .addComponent(route, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(flightInfoPanelLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(90, 90, 90)
                        .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(flightInfoPanelLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(110, 110, 110)
                        .addComponent(std, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(flightInfoPanelLayout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(80, 80, 80)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel34))
                .addGap(38, 38, 38)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 535, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );
        flightInfoPanelLayout.setVerticalGroup(
            flightInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(flightInfoPanelLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(flightInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(flightInfoPanelLayout.createSequentialGroup()
                        .addComponent(jLabel41)
                        .addGap(8, 8, 8)
                        .addComponent(jLabel42))
                    .addGroup(flightInfoPanelLayout.createSequentialGroup()
                        .addComponent(regCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(crewCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(flightInfoPanelLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jButton9)))
                .addGap(18, 18, 18)
                .addGroup(flightInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel43)
                    .addComponent(ac_type, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(flightInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel44)
                    .addComponent(route, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(flightInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel45)
                    .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(flightInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel46)
                    .addComponent(std, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(flightInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(flightInfoPanelLayout.createSequentialGroup()
                        .addGap(260, 260, 260)
                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(flightInfoPanelLayout.createSequentialGroup()
                        .addGap(240, 240, 240)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(flightInfoPanelLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLayeredPane1.add(flightInfoPanel, "card2");

        distributionPanel.setBackground(new java.awt.Color(255, 255, 255));
        distributionPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                distributionPanelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                distributionPanelMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                distributionPanelMousePressed(evt);
            }
        });
        distributionPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel20.setBackground(new java.awt.Color(96, 126, 137));
        jPanel20.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel20.setLayout(null);

        CFG_panel.setBackground(new java.awt.Color(255, 255, 255));
        CFG_panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 0, 102)));
        CFG_panel.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        CFG_panel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CFG_panelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                CFG_panelMouseExited(evt);
            }
        });

        CFG.setBackground(new java.awt.Color(225, 225, 225));
        CFG.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        CFG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CFG.setText("N");
        CFG.setName("CFG");
        CFG.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CFGMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CFGMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                CFGMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                CFGMousePressed(evt);
            }
        });

        javax.swing.GroupLayout CFG_panelLayout = new javax.swing.GroupLayout(CFG_panel);
        CFG_panel.setLayout(CFG_panelLayout);
        CFG_panelLayout.setHorizontalGroup(
            CFG_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(CFG, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
        );
        CFG_panelLayout.setVerticalGroup(
            CFG_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(CFG, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
        );

        jPanel20.add(CFG_panel);
        CFG_panel.setBounds(182, 60, 175, 80);

        CFR_panel.setBackground(new java.awt.Color(255, 255, 255));
        CFR_panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(86, 36, 36)));
        CFR_panel.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        CFR_panel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CFR_panelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                CFR_panelMouseExited(evt);
            }
        });

        CFR.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        CFR.setText("N");
        CFR.setName("CFR");
        CFR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CFRMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                CFRMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                CFRMousePressed(evt);
            }
        });

        javax.swing.GroupLayout CFR_panelLayout = new javax.swing.GroupLayout(CFR_panel);
        CFR_panel.setLayout(CFR_panelLayout);
        CFR_panelLayout.setHorizontalGroup(
            CFR_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(CFR, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
        );
        CFR_panelLayout.setVerticalGroup(
            CFR_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(CFR, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
        );

        jPanel20.add(CFR_panel);
        CFR_panel.setBounds(182, 60, 136, 80);

        FJG_panel.setBackground(new java.awt.Color(255, 255, 255));
        FJG_panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 0, 102)));
        FJG_panel.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        FJG_panel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                FJG_panelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                FJG_panelMouseExited(evt);
            }
        });

        FJG.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        FJG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        FJG.setText("N");
        FJG.setName("FJG");
        FJG.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                FJGMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                FJGMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                FJGMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                FJGMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout FJG_panelLayout = new javax.swing.GroupLayout(FJG_panel);
        FJG_panel.setLayout(FJG_panelLayout);
        FJG_panelLayout.setHorizontalGroup(
            FJG_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(FJG, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
        );
        FJG_panelLayout.setVerticalGroup(
            FJG_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(FJG, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
        );

        jPanel20.add(FJG_panel);
        FJG_panel.setBounds(355, 60, 175, 80);

        JLG_panel.setBackground(new java.awt.Color(255, 255, 255));
        JLG_panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 0, 102)));
        JLG_panel.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        JLG_panel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                JLG_panelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                JLG_panelMouseExited(evt);
            }
        });
        JLG_panel.setLayout(null);

        JLG.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        JLG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JLG.setText("N");
        JLG.setName("JLG");
        JLG.setToolTipText("");
        JLG.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                JLGMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                JLGMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                JLGMousePressed(evt);
            }
        });
        JLG_panel.add(JLG);
        JLG.setBounds(0, 0, 175, 80);

        jPanel20.add(JLG_panel);
        JLG_panel.setBounds(528, 60, 175, 80);

        FJR_panel.setBackground(new java.awt.Color(255, 255, 255));
        FJR_panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(86, 36, 36)));
        FJR_panel.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        FJR_panel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                FJR_panelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                FJR_panelMouseExited(evt);
            }
        });

        FJR.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        FJR.setText("N");
        FJR.setName("FJR");
        FJR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                FJRMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                FJRMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                FJRMousePressed(evt);
            }
        });

        javax.swing.GroupLayout FJR_panelLayout = new javax.swing.GroupLayout(FJR_panel);
        FJR_panel.setLayout(FJR_panelLayout);
        FJR_panelLayout.setHorizontalGroup(
            FJR_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(FJR, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
        );
        FJR_panelLayout.setVerticalGroup(
            FJR_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(FJR, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
        );

        jPanel20.add(FJR_panel);
        FJR_panel.setBounds(364, 60, 136, 80);

        JLR_panel.setBackground(new java.awt.Color(255, 255, 255));
        JLR_panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(86, 36, 36)));
        JLR_panel.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        JLR_panel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                JLR_panelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                JLR_panelMouseExited(evt);
            }
        });

        JLR.setBackground(new java.awt.Color(225, 225, 225));
        JLR.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        JLR.setText("N");
        JLR.setName("JLR");
        JLR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                JLRMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                JLRMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                JLRMousePressed(evt);
            }
        });

        javax.swing.GroupLayout JLR_panelLayout = new javax.swing.GroupLayout(JLR_panel);
        JLR_panel.setLayout(JLR_panelLayout);
        JLR_panelLayout.setHorizontalGroup(
            JLR_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JLR, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
        );
        JLR_panelLayout.setVerticalGroup(
            JLR_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JLR, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
        );

        jPanel20.add(JLR_panel);
        JLR_panel.setBounds(500, 60, 136, 80);

        LPR_panel.setBackground(new java.awt.Color(255, 255, 255));
        LPR_panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(86, 36, 36)));
        LPR_panel.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        LPR_panel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                LPR_panelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                LPR_panelMouseExited(evt);
            }
        });

        LPR.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        LPR.setText("N");
        LPR.setName("LPR");
        LPR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                LPRMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                LPRMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                LPRMousePressed(evt);
            }
        });

        javax.swing.GroupLayout LPR_panelLayout = new javax.swing.GroupLayout(LPR_panel);
        LPR_panel.setLayout(LPR_panelLayout);
        LPR_panelLayout.setHorizontalGroup(
            LPR_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(LPR, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
        );
        LPR_panelLayout.setVerticalGroup(
            LPR_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(LPR, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
        );

        jPanel20.add(LPR_panel);
        LPR_panel.setBounds(636, 60, 136, 80);

        AB_panel.setBackground(new java.awt.Color(255, 255, 255));
        AB_panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 204, 0)));
        AB_panel.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        AB_panel.setLayout(null);

        AB.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        AB.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AB.setText("N");
        AB.setName("AB");
        AB.setToolTipText("");
        AB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BCMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ABMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ABMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ABMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                ABMouseReleased(evt);
            }
        });
        AB_panel.add(AB);
        AB.setBounds(0, 0, 90, 80);

        jPanel20.add(AB_panel);
        AB_panel.setBounds(0, 60, 90, 80);

        BC_panel.setBackground(new java.awt.Color(255, 255, 255));
        BC_panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 204, 0)));
        BC_panel.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        BC_panel.setLayout(null);

        BC.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        BC.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BC.setText("N");
        BC.setName("BC");
        BC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BCMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BCMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                BCMousePressed(evt);
            }
        });
        BC_panel.add(BC);
        BC.setBounds(0, 0, 90, 80);

        jPanel20.add(BC_panel);
        BC_panel.setBounds(90, 60, 90, 80);

        CE_panel.setBackground(new java.awt.Color(255, 255, 255));
        CE_panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 204, 0)));
        CE_panel.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        CE_panel.setLayout(null);

        CE.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        CE.setText("N");
        CE.setName("CE");
        CE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CEMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                CEMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                CEMousePressed(evt);
            }
        });
        CE_panel.add(CE);
        CE.setBounds(0, 0, 90, 80);

        jPanel20.add(CE_panel);
        CE_panel.setBounds(180, 60, 90, 80);

        EF_panel.setBackground(new java.awt.Color(255, 255, 255));
        EF_panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 204, 0)));
        EF_panel.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        EF_panel.setLayout(null);

        EF.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        EF.setText("N");
        EF.setName("EF");
        EF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                EFMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                EFMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                EFMousePressed(evt);
            }
        });
        EF_panel.add(EF);
        EF.setBounds(0, 0, 90, 80);

        jPanel20.add(EF_panel);
        EF_panel.setBounds(270, 60, 90, 80);

        FH_panel.setBackground(new java.awt.Color(255, 255, 255));
        FH_panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 204, 0)));
        FH_panel.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        FH_panel.setLayout(null);

        FH.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        FH.setText("N");
        FH.setName("FH");
        FH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                FHMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                FHMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                FHMousePressed(evt);
            }
        });
        FH_panel.add(FH);
        FH.setBounds(0, 0, 90, 80);

        jPanel20.add(FH_panel);
        FH_panel.setBounds(360, 60, 90, 80);

        HJ_panel.setBackground(new java.awt.Color(255, 255, 255));
        HJ_panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 204, 0)));
        HJ_panel.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        HJ_panel.setLayout(null);

        HJ.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        HJ.setText("N");
        HJ.setName("HJ");
        HJ.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                HJMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                HJMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                HJMousePressed(evt);
            }
        });
        HJ_panel.add(HJ);
        HJ.setBounds(0, 0, 90, 80);

        jPanel20.add(HJ_panel);
        HJ_panel.setBounds(450, 60, 90, 80);

        JK_panel.setBackground(new java.awt.Color(255, 255, 255));
        JK_panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 204, 0)));
        JK_panel.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        JK_panel.setLayout(null);

        JK.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        JK.setText("N");
        JK.setName("JK");
        JK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                JKMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                JKMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                JKMousePressed(evt);
            }
        });
        JK_panel.add(JK);
        JK.setBounds(0, 0, 90, 80);

        jPanel20.add(JK_panel);
        JK_panel.setBounds(540, 60, 90, 80);

        KM_panel.setBackground(new java.awt.Color(255, 255, 255));
        KM_panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 204, 0)));
        KM_panel.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        KM_panel.setLayout(null);

        KM.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        KM.setText("N");
        KM.setName("KM");
        KM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                KMMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                KMMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                KMMousePressed(evt);
            }
        });
        KM_panel.add(KM);
        KM.setBounds(0, 0, 90, 80);

        jPanel20.add(KM_panel);
        KM_panel.setBounds(630, 60, 90, 80);

        MP_panel.setBackground(new java.awt.Color(255, 255, 255));
        MP_panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 204, 0)));
        MP_panel.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        MP_panel.setLayout(null);

        MP.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        MP.setText("N");
        MP.setName("MP");
        MP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MPMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MPMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MPMousePressed(evt);
            }
        });
        MP_panel.add(MP);
        MP.setBounds(0, 0, 90, 80);

        jPanel20.add(MP_panel);
        MP_panel.setBounds(720, 60, 90, 80);

        A_panel.setBackground(new java.awt.Color(255, 255, 255));
        A_panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255)));
        A_panel.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        A_panel.setLayout(null);

        A.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        A.setText("N");
        A.setName("A");
        A.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                AMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                AMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                AMousePressed(evt);
            }
        });
        A_panel.add(A);
        A.setBounds(0, 0, 62, 120);

        jPanel20.add(A_panel);
        A_panel.setBounds(0, 40, 62, 120);

        B_panel.setBackground(new java.awt.Color(255, 255, 255));
        B_panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255)));
        B_panel.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        B_panel.setLayout(null);

        B.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        B.setText("N");
        B.setName("B");
        B.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                BMousePressed(evt);
            }
        });
        B_panel.add(B);
        B.setBounds(0, 0, 62, 120);

        jPanel20.add(B_panel);
        B_panel.setBounds(62, 40, 62, 120);

        C_panel.setBackground(new java.awt.Color(255, 255, 255));
        C_panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255)));
        C_panel.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        C_panel.setLayout(null);

        C.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        C.setText("N");
        C.setName("C");
        C.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                CMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                CMousePressed(evt);
            }
        });
        C_panel.add(C);
        C.setBounds(0, 0, 62, 120);

        jPanel20.add(C_panel);
        C_panel.setBounds(124, 40, 62, 120);

        D_panel.setBackground(new java.awt.Color(255, 255, 255));
        D_panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255)));
        D_panel.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        D_panel.setLayout(null);

        D.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        D.setText("N");
        D.setName("D");
        D.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                DMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                DMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                DMousePressed(evt);
            }
        });
        D_panel.add(D);
        D.setBounds(0, 0, 62, 120);

        jPanel20.add(D_panel);
        D_panel.setBounds(186, 40, 62, 120);

        E_panel.setBackground(new java.awt.Color(255, 255, 255));
        E_panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255)));
        E_panel.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        E_panel.setLayout(null);

        E.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        E.setText("N");
        E.setName("E");
        E.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                EMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                EMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                EMousePressed(evt);
            }
        });
        E_panel.add(E);
        E.setBounds(0, 0, 62, 120);

        jPanel20.add(E_panel);
        E_panel.setBounds(248, 40, 62, 120);

        F_panel.setBackground(new java.awt.Color(255, 255, 255));
        F_panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255)));
        F_panel.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        F_panel.setLayout(null);

        F.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        F.setText("N");
        F.setName("F");
        F.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                FMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                FMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                FMousePressed(evt);
            }
        });
        F_panel.add(F);
        F.setBounds(0, 0, 62, 120);

        jPanel20.add(F_panel);
        F_panel.setBounds(310, 40, 62, 120);

        G_panel.setBackground(new java.awt.Color(255, 255, 255));
        G_panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255)));
        G_panel.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        G_panel.setLayout(null);

        G.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        G.setText("N");
        G.setName("G");
        G.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                GMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                GMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                GMousePressed(evt);
            }
        });
        G_panel.add(G);
        G.setBounds(0, 0, 62, 120);

        jPanel20.add(G_panel);
        G_panel.setBounds(372, 40, 62, 120);

        H_panel.setBackground(new java.awt.Color(255, 255, 255));
        H_panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255)));
        H_panel.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        H_panel.setLayout(null);

        H.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        H.setText("N");
        H.setName("H");
        H.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                HMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                HMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                HMousePressed(evt);
            }
        });
        H_panel.add(H);
        H.setBounds(0, 0, 62, 120);

        jPanel20.add(H_panel);
        H_panel.setBounds(434, 40, 62, 120);

        J_panel.setBackground(new java.awt.Color(255, 255, 255));
        J_panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255)));
        J_panel.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        J_panel.setLayout(null);

        J.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        J.setText("N");
        J.setName("J");
        J.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                JMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                JMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                JMousePressed(evt);
            }
        });
        J_panel.add(J);
        J.setBounds(0, 0, 70, 120);

        jPanel20.add(J_panel);
        J_panel.setBounds(496, 40, 70, 120);

        K_panel.setBackground(new java.awt.Color(255, 255, 255));
        K_panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255)));
        K_panel.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        K_panel.setLayout(null);

        K.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        K.setText("N");
        K.setName("K");
        K.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                KMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                KMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                KMousePressed(evt);
            }
        });
        K_panel.add(K);
        K.setBounds(0, 0, 67, 120);

        jPanel20.add(K_panel);
        K_panel.setBounds(565, 40, 67, 120);

        L_panel.setBackground(new java.awt.Color(255, 255, 255));
        L_panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255)));
        L_panel.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        L_panel.setLayout(null);

        L.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        L.setText("N");
        L.setName("L");
        L.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                LMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                LMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                LMousePressed(evt);
            }
        });
        L_panel.add(L);
        L.setBounds(0, 0, 67, 120);

        jPanel20.add(L_panel);
        L_panel.setBounds(630, 40, 68, 120);

        M_panel.setBackground(new java.awt.Color(255, 255, 255));
        M_panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255)));
        M_panel.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        M_panel.setLayout(null);

        M.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        M.setText("N");
        M.setName("M");
        M.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MMousePressed(evt);
            }
        });
        M_panel.add(M);
        M.setBounds(0, 0, 60, 120);

        jPanel20.add(M_panel);
        M_panel.setBounds(697, 40, 60, 120);

        P_panel.setBackground(new java.awt.Color(255, 255, 255));
        P_panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255)));
        P_panel.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        P_panel.setLayout(null);

        P.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        P.setText("N");
        P.setName("P");
        P.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                PMousePressed(evt);
            }
        });
        P_panel.add(P);
        P.setBounds(0, 0, 60, 120);

        jPanel20.add(P_panel);
        P_panel.setBounds(762, 40, 60, 120);

        R_panel.setBackground(new java.awt.Color(255, 255, 255));
        R_panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255)));
        R_panel.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        R_panel.setLayout(null);

        R.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        R.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        R.setText("N");
        R.setName("R");
        R.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                RMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                RMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                RMousePressed(evt);
            }
        });
        R_panel.add(R);
        R.setBounds(0, 0, 60, 120);

        jPanel20.add(R_panel);
        R_panel.setBounds(836, 40, 60, 120);

        S_panel.setBackground(new java.awt.Color(255, 255, 255));
        S_panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255)));
        S_panel.setLayout(null);

        S.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        S.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        S.setText("N");
        S.setName("S");
        S.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                SMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                SMousePressed(evt);
            }
        });
        S_panel.add(S);
        S.setBounds(2, 0, 62, 120);

        jPanel20.add(S_panel);
        S_panel.setBounds(904, 40, 62, 120);

        T_panel.setBackground(new java.awt.Color(255, 255, 255));
        T_panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255)));
        T_panel.setLayout(null);

        T.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        T.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        T.setText("N");
        T.setName("T");
        T.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                TMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                TMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TMousePressed(evt);
            }
        });
        T_panel.add(T);
        T.setBounds(0, 0, 62, 120);

        jPanel20.add(T_panel);
        T_panel.setBounds(974, 40, 62, 120);

        U_panel.setBackground(new java.awt.Color(255, 255, 255));
        U_panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255)));
        U_panel.setLayout(null);

        U.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        U.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        U.setText("N");
        U.setName("U");
        U.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                UMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                UMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                UMousePressed(evt);
            }
        });
        U_panel.add(U);
        U.setBounds(0, 0, 62, 120);

        jPanel20.add(U_panel);
        U_panel.setBounds(1045, 40, 62, 120);

        AA_panel.setBackground(new java.awt.Color(255, 255, 255));
        AA_panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        AA_panel.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        AA_panel.setLayout(null);

        AA.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        AA.setText("N");
        AA.setName("AA");
        AA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                AAMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                AAMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                AAMousePressed(evt);
            }
        });
        AA_panel.add(AA);
        AA.setBounds(0, 0, 69, 120);

        jPanel20.add(AA_panel);
        AA_panel.setBounds(0, 40, 69, 120);

        BB_panel.setBackground(new java.awt.Color(255, 255, 255));
        BB_panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        BB_panel.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        BB_panel.setLayout(null);

        BB.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        BB.setText("N");
        BB.setName("BB");
        BB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BBMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BBMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                BBMousePressed(evt);
            }
        });
        BB_panel.add(BB);
        BB.setBounds(0, 0, 69, 120);

        jPanel20.add(BB_panel);
        BB_panel.setBounds(69, 40, 69, 120);

        CC_panel.setBackground(new java.awt.Color(255, 255, 255));
        CC_panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        CC_panel.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        CC_panel.setLayout(null);

        CC.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        CC.setText("N");
        CC.setName("CC");
        CC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CCMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                CCMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                CCMousePressed(evt);
            }
        });
        CC_panel.add(CC);
        CC.setBounds(0, 0, 69, 120);

        jPanel20.add(CC_panel);
        CC_panel.setBounds(138, 40, 69, 120);

        DD_panel.setBackground(new java.awt.Color(255, 255, 255));
        DD_panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        DD_panel.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        DD_panel.setLayout(null);

        DD.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        DD.setText("N");
        DD.setName("DD");
        DD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                DDMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                DDMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                DDMousePressed(evt);
            }
        });
        DD_panel.add(DD);
        DD.setBounds(0, 0, 69, 120);

        jPanel20.add(DD_panel);
        DD_panel.setBounds(207, 40, 69, 120);

        EE_panel.setBackground(new java.awt.Color(255, 255, 255));
        EE_panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        EE_panel.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        EE_panel.setLayout(null);

        EE.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        EE.setText("N");
        EE.setName("EE");
        EE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                EEMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                EEMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                EEMousePressed(evt);
            }
        });
        EE_panel.add(EE);
        EE.setBounds(0, 0, 69, 120);

        jPanel20.add(EE_panel);
        EE_panel.setBounds(276, 40, 69, 120);

        FF_panel.setBackground(new java.awt.Color(255, 255, 255));
        FF_panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        FF_panel.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        FF_panel.setLayout(null);

        FF.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        FF.setText("N");
        FF.setName("FF");
        FF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                FFMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                FFMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                FFMousePressed(evt);
            }
        });
        FF_panel.add(FF);
        FF.setBounds(0, 0, 69, 120);

        jPanel20.add(FF_panel);
        FF_panel.setBounds(345, 40, 69, 120);

        GG_panel.setBackground(new java.awt.Color(255, 255, 255));
        GG_panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        GG_panel.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        GG_panel.setLayout(null);

        GG.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        GG.setText("N");
        GG.setName("GG");
        GG.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                GGMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                GGMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                GGMousePressed(evt);
            }
        });
        GG_panel.add(GG);
        GG.setBounds(0, 0, 69, 120);

        jPanel20.add(GG_panel);
        GG_panel.setBounds(414, 40, 69, 120);

        HH_panel.setBackground(new java.awt.Color(255, 255, 255));
        HH_panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        HH_panel.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        HH_panel.setLayout(null);

        HH.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        HH.setText("N");
        HH.setName("HH");
        HH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                HHMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                HHMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                HHMousePressed(evt);
            }
        });
        HH_panel.add(HH);
        HH.setBounds(0, 0, 69, 120);

        jPanel20.add(HH_panel);
        HH_panel.setBounds(483, 40, 69, 120);

        JJ_panel.setBackground(new java.awt.Color(255, 255, 255));
        JJ_panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        JJ_panel.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        JJ_panel.setLayout(null);

        JJ.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        JJ.setText("N");
        JJ.setName("JJ");
        JJ.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                JJMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                JJMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                JJMousePressed(evt);
            }
        });
        JJ_panel.add(JJ);
        JJ.setBounds(0, 0, 69, 120);

        jPanel20.add(JJ_panel);
        JJ_panel.setBounds(552, 40, 69, 120);

        KK_panel.setBackground(new java.awt.Color(255, 255, 255));
        KK_panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        KK_panel.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        KK_panel.setLayout(null);

        KK.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        KK.setText("N");
        KK.setName("KK");
        KK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                KKMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                KKMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                KKMousePressed(evt);
            }
        });
        KK_panel.add(KK);
        KK.setBounds(0, 0, 69, 120);

        jPanel20.add(KK_panel);
        KK_panel.setBounds(621, 40, 69, 120);

        LL_panel.setBackground(new java.awt.Color(255, 255, 255));
        LL_panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        LL_panel.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        LL_panel.setLayout(null);

        LL.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        LL.setText("N");
        LL.setName("LL");
        LL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                LLMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                LLMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                LLMousePressed(evt);
            }
        });
        LL_panel.add(LL);
        LL.setBounds(0, 0, 69, 120);

        jPanel20.add(LL_panel);
        LL_panel.setBounds(690, 40, 69, 120);

        MM_panel.setBackground(new java.awt.Color(255, 255, 255));
        MM_panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        MM_panel.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        MM_panel.setLayout(null);

        MM.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        MM.setText("N");
        MM.setName("MM");
        MM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MMMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MMMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MMMousePressed(evt);
            }
        });
        MM_panel.add(MM);
        MM.setBounds(0, 0, 69, 120);

        jPanel20.add(MM_panel);
        MM_panel.setBounds(759, 40, 69, 120);

        PP_panel.setBackground(new java.awt.Color(255, 255, 255));
        PP_panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        PP_panel.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        PP_panel.setLayout(null);

        PP.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        PP.setText("N");
        PP.setName("PP");
        PP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PPMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PPMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                PPMousePressed(evt);
            }
        });
        PP_panel.add(PP);
        PP.setBounds(0, 0, 69, 120);

        jPanel20.add(PP_panel);
        PP_panel.setBounds(828, 40, 69, 120);

        RR_panel.setBackground(new java.awt.Color(255, 255, 255));
        RR_panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        RR_panel.setLayout(null);

        RR.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        RR.setText("N");
        RR.setName("RR");
        RR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                RRMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                RRMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                RRMousePressed(evt);
            }
        });
        RR_panel.add(RR);
        RR.setBounds(0, 0, 69, 120);

        jPanel20.add(RR_panel);
        RR_panel.setBounds(897, 40, 69, 120);

        SS_panel.setBackground(new java.awt.Color(255, 255, 255));
        SS_panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        SS_panel.setLayout(null);

        SS.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        SS.setText("N");
        SS.setName("SS");
        SS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SSMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SSMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                SSMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                SSMousePressed(evt);
            }
        });
        SS_panel.add(SS);
        SS.setBounds(0, 0, 69, 120);

        jPanel20.add(SS_panel);
        SS_panel.setBounds(966, 40, 69, 120);

        TT_panel.setBackground(new java.awt.Color(255, 255, 255));
        TT_panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        TT_panel.setLayout(null);

        TT.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        TT.setText("N");
        TT.setName("TT");
        TT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                TTMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                TTMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TTMousePressed(evt);
            }
        });
        TT_panel.add(TT);
        TT.setBounds(0, 0, 69, 120);

        jPanel20.add(TT_panel);
        TT_panel.setBounds(1035, 40, 69, 120);

        ABR_panel.setBackground(new java.awt.Color(255, 255, 255));
        ABR_panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 0)));
        ABR_panel.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        ABR_panel.setLayout(null);

        ABR.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        ABR.setText("N");
        ABR.setName("ABR");
        ABR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ABRMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ABRMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ABRMousePressed(evt);
            }
        });
        ABR_panel.add(ABR);
        ABR.setBounds(0, 0, 90, 90);

        jPanel20.add(ABR_panel);
        ABR_panel.setBounds(0, 10, 90, 90);

        ABL_panel.setBackground(new java.awt.Color(255, 255, 255));
        ABL_panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 0)));
        ABL_panel.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        ABL_panel.setLayout(null);

        ABL.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        ABL.setText("N");
        ABL.setName("ABL");
        ABL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ABLMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ABLMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ABLMousePressed(evt);
            }
        });
        ABL_panel.add(ABL);
        ABL.setBounds(0, 0, 90, 90);

        jPanel20.add(ABL_panel);
        ABL_panel.setBounds(0, 100, 90, 90);

        BCR_panel.setBackground(new java.awt.Color(255, 255, 255));
        BCR_panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 0)));
        BCR_panel.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        BCR_panel.setLayout(null);

        BCR.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        BCR.setText("N");
        BCR.setName("BCR");
        BCR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BCRMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BCRMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                BCRMousePressed(evt);
            }
        });
        BCR_panel.add(BCR);
        BCR.setBounds(0, 0, 90, 90);

        jPanel20.add(BCR_panel);
        BCR_panel.setBounds(90, 10, 90, 90);

        BCL_panel.setBackground(new java.awt.Color(255, 255, 255));
        BCL_panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 0)));
        BCL_panel.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        BCL_panel.setLayout(null);

        BCL.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        BCL.setText("N");
        BCL.setName("BCL");
        BCL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BCLMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BCLMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                BCLMousePressed(evt);
            }
        });
        BCL_panel.add(BCL);
        BCL.setBounds(0, 0, 90, 90);

        jPanel20.add(BCL_panel);
        BCL_panel.setBounds(90, 100, 90, 90);

        CER_panel.setBackground(new java.awt.Color(255, 255, 255));
        CER_panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 0)));
        CER_panel.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        CER_panel.setLayout(null);

        CER.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        CER.setText("N");
        CER.setName("CER");
        CER.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CERMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                CERMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                CERMousePressed(evt);
            }
        });
        CER_panel.add(CER);
        CER.setBounds(0, 0, 90, 90);

        jPanel20.add(CER_panel);
        CER_panel.setBounds(180, 10, 90, 90);

        CEL_panel.setBackground(new java.awt.Color(255, 255, 255));
        CEL_panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 0)));
        CEL_panel.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        CEL_panel.setLayout(null);

        CEL.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        CEL.setText("N");
        CEL.setName("CEL");
        CEL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CELMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                CELMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                CELMousePressed(evt);
            }
        });
        CEL_panel.add(CEL);
        CEL.setBounds(0, 0, 90, 90);

        jPanel20.add(CEL_panel);
        CEL_panel.setBounds(180, 100, 90, 90);

        HJL_panel.setBackground(new java.awt.Color(255, 255, 255));
        HJL_panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 0)));
        HJL_panel.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        HJL_panel.setLayout(null);

        HJL.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        HJL.setText("N");
        HJL.setName("HJL");
        HJL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                HJLMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                HJLMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                HJLMousePressed(evt);
            }
        });
        HJL_panel.add(HJL);
        HJL.setBounds(0, 0, 90, 90);

        jPanel20.add(HJL_panel);
        HJL_panel.setBounds(450, 100, 90, 90);

        FHL_panel.setBackground(new java.awt.Color(255, 255, 255));
        FHL_panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 0)));
        FHL_panel.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        FHL_panel.setLayout(null);

        FHL.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        FHL.setText("N");
        FHL.setName("FHL");
        FHL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                FHLMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                FHLMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                FHLMousePressed(evt);
            }
        });
        FHL_panel.add(FHL);
        FHL.setBounds(0, 0, 90, 90);

        jPanel20.add(FHL_panel);
        FHL_panel.setBounds(360, 100, 90, 90);

        EFL_panel.setBackground(new java.awt.Color(255, 255, 255));
        EFL_panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 0)));
        EFL_panel.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        EFL_panel.setLayout(null);

        EFL.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        EFL.setText("N");
        EFL.setName("EFL");
        EFL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                EFLMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                EFLMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                EFLMousePressed(evt);
            }
        });
        EFL_panel.add(EFL);
        EFL.setBounds(0, 0, 90, 90);

        jPanel20.add(EFL_panel);
        EFL_panel.setBounds(270, 100, 90, 90);

        EFR_panel.setBackground(new java.awt.Color(255, 255, 255));
        EFR_panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 0)));
        EFR_panel.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        EFR_panel.setLayout(null);

        EFR.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        EFR.setText("N");
        EFR.setName("EFR");
        EFR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                EFRMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                EFRMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                EFRMousePressed(evt);
            }
        });
        EFR_panel.add(EFR);
        EFR.setBounds(0, 0, 90, 90);

        jPanel20.add(EFR_panel);
        EFR_panel.setBounds(270, 10, 90, 90);

        FHR_panel.setBackground(new java.awt.Color(255, 255, 255));
        FHR_panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 0)));
        FHR_panel.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        FHR_panel.setLayout(null);

        FHR.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        FHR.setText("N");
        FHR.setName("FHR");
        FHR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                FHRMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                FHRMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                FHRMousePressed(evt);
            }
        });
        FHR_panel.add(FHR);
        FHR.setBounds(0, 0, 90, 90);

        jPanel20.add(FHR_panel);
        FHR_panel.setBounds(360, 10, 90, 90);

        HJR_panel.setBackground(new java.awt.Color(255, 255, 255));
        HJR_panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 0)));
        HJR_panel.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        HJR_panel.setLayout(null);

        HJR.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        HJR.setText("N");
        HJR.setName("HJR");
        HJR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                HJRMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                HJRMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                HJRMousePressed(evt);
            }
        });
        HJR_panel.add(HJR);
        HJR.setBounds(0, 0, 90, 90);

        jPanel20.add(HJR_panel);
        HJR_panel.setBounds(450, 10, 90, 90);

        MPL_panel.setBackground(new java.awt.Color(255, 255, 255));
        MPL_panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 0)));
        MPL_panel.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        MPL_panel.setLayout(null);

        MPL.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        MPL.setText("N");
        MPL.setName("MPL");
        MPL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MPLMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MPLMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MPLMousePressed(evt);
            }
        });
        MPL_panel.add(MPL);
        MPL.setBounds(0, 0, 90, 90);

        jPanel20.add(MPL_panel);
        MPL_panel.setBounds(720, 100, 90, 90);

        KML_panel.setBackground(new java.awt.Color(255, 255, 255));
        KML_panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 0)));
        KML_panel.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        KML_panel.setLayout(null);

        KML.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        KML.setText("N");
        KML.setName("KML");
        KML.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                KMLMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                KMLMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                KMLMousePressed(evt);
            }
        });
        KML_panel.add(KML);
        KML.setBounds(0, 0, 90, 90);

        jPanel20.add(KML_panel);
        KML_panel.setBounds(630, 100, 90, 90);

        JKL_panel.setBackground(new java.awt.Color(255, 255, 255));
        JKL_panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 0)));
        JKL_panel.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        JKL_panel.setLayout(null);

        JKL.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        JKL.setText("N");
        JKL.setName("JKL");
        JKL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                JKLMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                JKLMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                JKLMousePressed(evt);
            }
        });
        JKL_panel.add(JKL);
        JKL.setBounds(0, 0, 90, 90);

        jPanel20.add(JKL_panel);
        JKL_panel.setBounds(540, 100, 90, 90);

        JKR_panel.setBackground(new java.awt.Color(255, 255, 255));
        JKR_panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 0)));
        JKR_panel.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        JKR_panel.setLayout(null);

        JKR.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        JKR.setText("N");
        JKR.setName("JKR");
        JKR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                JKRMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                JKRMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                JKRMousePressed(evt);
            }
        });
        JKR_panel.add(JKR);
        JKR.setBounds(0, 0, 90, 90);

        jPanel20.add(JKR_panel);
        JKR_panel.setBounds(540, 10, 90, 90);

        KMR_panel.setBackground(new java.awt.Color(255, 255, 255));
        KMR_panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 0)));
        KMR_panel.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        KMR_panel.setLayout(null);

        KMR.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        KMR.setText("N");
        KMR.setName("KMR");
        KMR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                KMRMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                KMRMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                KMRMousePressed(evt);
            }
        });
        KMR_panel.add(KMR);
        KMR.setBounds(0, 0, 90, 90);

        jPanel20.add(KMR_panel);
        KMR_panel.setBounds(630, 10, 90, 90);

        MPR_panel.setBackground(new java.awt.Color(255, 255, 255));
        MPR_panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 0)));
        MPR_panel.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        MPR_panel.setLayout(null);

        MPR.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        MPR.setText("N");
        MPR.setName("MPR");
        MPR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MPRMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MPRMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MPRMousePressed(evt);
            }
        });
        MPR_panel.add(MPR);
        MPR.setBounds(0, 0, 90, 90);

        jPanel20.add(MPR_panel);
        MPR_panel.setBounds(720, 10, 90, 90);

        PRL_panel.setBackground(new java.awt.Color(255, 255, 255));
        PRL_panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 0)));
        PRL_panel.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        PRL_panel.setLayout(null);

        PRL.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        PRL.setText("N");
        PRL.setName("PRL");
        PRL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PRLMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PRLMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                PRLMousePressed(evt);
            }
        });
        PRL_panel.add(PRL);
        PRL.setBounds(0, 0, 90, 90);

        jPanel20.add(PRL_panel);
        PRL_panel.setBounds(810, 100, 90, 90);

        PRR_panel.setBackground(new java.awt.Color(255, 255, 255));
        PRR_panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 0)));
        PRR_panel.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        PRR_panel.setLayout(null);

        PRR.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        PRR.setText("N");
        PRR.setName("PRR");
        PRR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PRRMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PRRMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                PRRMousePressed(evt);
            }
        });
        PRR_panel.add(PRR);
        PRR.setBounds(0, 0, 90, 90);

        jPanel20.add(PRR_panel);
        PRR_panel.setBounds(810, 10, 90, 90);

        checkboxMD2.setSelected(true);
        checkboxMD2.setText("MD2");
        checkboxMD2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkboxMD2ActionPerformed(evt);
            }
        });
        jPanel20.add(checkboxMD2);
        checkboxMD2.setBounds(999, 10, 60, 20);

        checkboxMD1.setSelected(true);
        checkboxMD1.setText("MD1");
        checkboxMD1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkboxMD1ActionPerformed(evt);
            }
        });
        jPanel20.add(checkboxMD1);
        checkboxMD1.setBounds(930, 10, 60, 20);

        checkboxMD3.setSelected(true);
        checkboxMD3.setText("MD3");
        checkboxMD3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkboxMD3ActionPerformed(evt);
            }
        });
        jPanel20.add(checkboxMD3);
        checkboxMD3.setBounds(930, 170, 60, 20);

        checkboxMD16.setSelected(true);
        checkboxMD16.setText("MD16");
        checkboxMD16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkboxMD16ActionPerformed(evt);
            }
        });
        jPanel20.add(checkboxMD16);
        checkboxMD16.setBounds(1000, 170, 60, 20);

        checkboxMD20.setSelected(true);
        checkboxMD20.setText("MD20");
        checkboxMD20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkboxMD20ActionPerformed(evt);
            }
        });
        jPanel20.add(checkboxMD20);
        checkboxMD20.setBounds(1060, 170, 60, 20);

        distributionPanel.add(jPanel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 1110, 201));

        deadload2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "sr", "ULD/BULK", "Gross", "Net Weight", "TARE", "Height", "Dest", "Commodity", "Location", "DG/SL", "SxS", "Overhang", "Onward Dest", "Description"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        deadload2.setToolTipText("bold");
        deadload2.setDragEnabled(true);
        deadload2.setDropMode(javax.swing.DropMode.INSERT_ROWS);
        deadload2.setSelectionBackground(new java.awt.Color(255, 102, 0));
        deadload2.getTableHeader().setReorderingAllowed(false);
        deadload2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deadload2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                deadload2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                deadload2MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                deadload2MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                deadload2MouseReleased(evt);
            }
        });
        jScrollPane4.setViewportView(deadload2);
        if (deadload2.getColumnModel().getColumnCount() > 0) {
            deadload2.getColumnModel().getColumn(0).setResizable(false);
            deadload2.getColumnModel().getColumn(1).setResizable(false);
            deadload2.getColumnModel().getColumn(2).setResizable(false);
            deadload2.getColumnModel().getColumn(3).setResizable(false);
            deadload2.getColumnModel().getColumn(4).setResizable(false);
            deadload2.getColumnModel().getColumn(5).setResizable(false);
            deadload2.getColumnModel().getColumn(6).setResizable(false);
            deadload2.getColumnModel().getColumn(7).setResizable(false);
            deadload2.getColumnModel().getColumn(8).setResizable(false);
        }

        distributionPanel.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 540, 700, 158));

        jTable5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "A", "B", "C", "D", "E", "J", "K", "L", "M", "P", "R", "S", "T", "U"
            }
        ));
        jScrollPane5.setViewportView(jTable5);

        distributionPanel.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 1110, 93));

        jButton11.setBackground(new java.awt.Color(39, 50, 56));
        jButton11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton11.setForeground(new java.awt.Color(255, 255, 255));
        jButton11.setText("OFFLOAD");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        distributionPanel.add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 510, -1, -1));

        jButton12.setBackground(new java.awt.Color(39, 50, 56));
        jButton12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton12.setForeground(new java.awt.Color(255, 255, 255));
        jButton12.setText("DEADLOAD");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        distributionPanel.add(jButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 510, -1, -1));

        jButton13.setBackground(new java.awt.Color(39, 50, 56));
        jButton13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton13.setForeground(new java.awt.Color(255, 255, 255));
        jButton13.setText("APPLY");
        distributionPanel.add(jButton13, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 510, -1, -1));

        jButton26.setBackground(new java.awt.Color(96, 126, 137));
        jButton26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/circle.png"))); // NOI18N
        jButton26.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jButton26MouseDragged(evt);
            }
        });
        jButton26.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton26MousePressed(evt);
            }
        });
        jButton26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton26ActionPerformed(evt);
            }
        });
        distributionPanel.add(jButton26, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 610, 10, 10));

        jButton27.setBackground(new java.awt.Color(96, 126, 137));
        jButton27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/circle.png"))); // NOI18N
        jButton27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton27ActionPerformed(evt);
            }
        });
        distributionPanel.add(jButton27, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 610, 10, 10));

        jLabel33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/chat.png"))); // NOI18N
        distributionPanel.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 350, 380, -1));

        jTable6.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ULD/BULK", "Gross", "Net Weight", "TARE", "Height", "Dest", "Commodity", "Location", "DG/SL", "Overhang", "SXS", "Description"
            }
        ));
        jTable6.setToolTipText("bold");
        jScrollPane6.setViewportView(jTable6);
        if (jTable6.getColumnModel().getColumnCount() > 0) {
            jTable6.getColumnModel().getColumn(0).setPreferredWidth(20);
            jTable6.getColumnModel().getColumn(1).setPreferredWidth(10);
            jTable6.getColumnModel().getColumn(2).setPreferredWidth(35);
            jTable6.getColumnModel().getColumn(3).setPreferredWidth(10);
            jTable6.getColumnModel().getColumn(4).setPreferredWidth(30);
            jTable6.getColumnModel().getColumn(5).setPreferredWidth(10);
            jTable6.getColumnModel().getColumn(6).setPreferredWidth(40);
            jTable6.getColumnModel().getColumn(7).setPreferredWidth(40);
            jTable6.getColumnModel().getColumn(8).setPreferredWidth(20);
            jTable6.getColumnModel().getColumn(9).setPreferredWidth(40);
            jTable6.getColumnModel().getColumn(10).setPreferredWidth(20);
            jTable6.getColumnModel().getColumn(11).setPreferredWidth(150);
        }

        distributionPanel.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 540, 699, 158));

        jPanel91.setBackground(new java.awt.Color(204, 204, 204));
        jPanel91.setLayout(null);

        jPanel92.setBackground(new java.awt.Color(255, 255, 255));
        jPanel92.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel92.setLayout(null);

        jLabel8.setText("N");
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel8MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel8MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel8MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel8MouseReleased(evt);
            }
        });
        jPanel92.add(jLabel8);
        jLabel8.setBounds(0, 0, 50, 70);

        jPanel91.add(jPanel92);
        jPanel92.setBounds(0, 30, 50, 70);

        jPanel93.setBackground(new java.awt.Color(255, 255, 255));
        jPanel93.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel93.setLayout(null);

        jLabel9.setText("N");
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel9MouseEntered(evt);
            }
        });
        jPanel93.add(jLabel9);
        jLabel9.setBounds(0, 0, 50, 70);

        jPanel91.add(jPanel93);
        jPanel93.setBounds(50, 30, 50, 71);

        jPanel95.setBackground(new java.awt.Color(255, 255, 255));
        jPanel95.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel96Layout = new javax.swing.GroupLayout(jPanel96);
        jPanel96.setLayout(jPanel96Layout);
        jPanel96Layout.setHorizontalGroup(
            jPanel96Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel96Layout.setVerticalGroup(
            jPanel96Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel95Layout = new javax.swing.GroupLayout(jPanel95);
        jPanel95.setLayout(jPanel95Layout);
        jPanel95Layout.setHorizontalGroup(
            jPanel95Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 48, Short.MAX_VALUE)
        );
        jPanel95Layout.setVerticalGroup(
            jPanel95Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 69, Short.MAX_VALUE)
        );

        jPanel91.add(jPanel95);
        jPanel95.setBounds(150, 30, 50, 71);

        jPanel94.setBackground(new java.awt.Color(255, 255, 255));
        jPanel94.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel94.setLayout(null);

        jLabel10.setText("N");
        jLabel10.setToolTipText("");
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel10MouseEntered(evt);
            }
        });
        jPanel94.add(jLabel10);
        jLabel10.setBounds(0, 0, 50, 70);

        jPanel91.add(jPanel94);
        jPanel94.setBounds(100, 30, 50, 70);

        jPanel99.setBackground(new java.awt.Color(255, 255, 255));
        jPanel99.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel99Layout = new javax.swing.GroupLayout(jPanel99);
        jPanel99.setLayout(jPanel99Layout);
        jPanel99Layout.setHorizontalGroup(
            jPanel99Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 48, Short.MAX_VALUE)
        );
        jPanel99Layout.setVerticalGroup(
            jPanel99Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 69, Short.MAX_VALUE)
        );

        jPanel91.add(jPanel99);
        jPanel99.setBounds(250, 30, 50, 71);

        jPanel100.setBackground(new java.awt.Color(255, 255, 255));
        jPanel100.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel100Layout = new javax.swing.GroupLayout(jPanel100);
        jPanel100.setLayout(jPanel100Layout);
        jPanel100Layout.setHorizontalGroup(
            jPanel100Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 48, Short.MAX_VALUE)
        );
        jPanel100Layout.setVerticalGroup(
            jPanel100Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel91.add(jPanel100);
        jPanel100.setBounds(200, 30, 50, 71);

        jPanel123.setBackground(new java.awt.Color(204, 204, 204));
        jPanel123.setLayout(null);

        jPanel124.setBackground(new java.awt.Color(255, 255, 255));
        jPanel124.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel124Layout = new javax.swing.GroupLayout(jPanel124);
        jPanel124.setLayout(jPanel124Layout);
        jPanel124Layout.setHorizontalGroup(
            jPanel124Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 48, Short.MAX_VALUE)
        );
        jPanel124Layout.setVerticalGroup(
            jPanel124Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 69, Short.MAX_VALUE)
        );

        jPanel123.add(jPanel124);
        jPanel124.setBounds(0, 30, 50, 71);

        jPanel125.setBackground(new java.awt.Color(255, 255, 255));
        jPanel125.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel125Layout = new javax.swing.GroupLayout(jPanel125);
        jPanel125.setLayout(jPanel125Layout);
        jPanel125Layout.setHorizontalGroup(
            jPanel125Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 48, Short.MAX_VALUE)
        );
        jPanel125Layout.setVerticalGroup(
            jPanel125Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel123.add(jPanel125);
        jPanel125.setBounds(50, 30, 50, 71);

        jPanel126.setBackground(new java.awt.Color(255, 255, 255));
        jPanel126.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel127Layout = new javax.swing.GroupLayout(jPanel127);
        jPanel127.setLayout(jPanel127Layout);
        jPanel127Layout.setHorizontalGroup(
            jPanel127Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel127Layout.setVerticalGroup(
            jPanel127Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel126Layout = new javax.swing.GroupLayout(jPanel126);
        jPanel126.setLayout(jPanel126Layout);
        jPanel126Layout.setHorizontalGroup(
            jPanel126Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 48, Short.MAX_VALUE)
        );
        jPanel126Layout.setVerticalGroup(
            jPanel126Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 69, Short.MAX_VALUE)
        );

        jPanel123.add(jPanel126);
        jPanel126.setBounds(150, 30, 50, 71);

        jPanel128.setBackground(new java.awt.Color(255, 255, 255));
        jPanel128.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel128Layout = new javax.swing.GroupLayout(jPanel128);
        jPanel128.setLayout(jPanel128Layout);
        jPanel128Layout.setHorizontalGroup(
            jPanel128Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 48, Short.MAX_VALUE)
        );
        jPanel128Layout.setVerticalGroup(
            jPanel128Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 69, Short.MAX_VALUE)
        );

        jPanel123.add(jPanel128);
        jPanel128.setBounds(100, 30, 50, 71);

        jPanel129.setBackground(new java.awt.Color(255, 255, 255));
        jPanel129.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel129Layout = new javax.swing.GroupLayout(jPanel129);
        jPanel129.setLayout(jPanel129Layout);
        jPanel129Layout.setHorizontalGroup(
            jPanel129Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 48, Short.MAX_VALUE)
        );
        jPanel129Layout.setVerticalGroup(
            jPanel129Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 69, Short.MAX_VALUE)
        );

        jPanel123.add(jPanel129);
        jPanel129.setBounds(250, 30, 50, 71);

        jPanel130.setBackground(new java.awt.Color(255, 255, 255));
        jPanel130.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel130Layout = new javax.swing.GroupLayout(jPanel130);
        jPanel130.setLayout(jPanel130Layout);
        jPanel130Layout.setHorizontalGroup(
            jPanel130Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 48, Short.MAX_VALUE)
        );
        jPanel130Layout.setVerticalGroup(
            jPanel130Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel123.add(jPanel130);
        jPanel130.setBounds(200, 30, 50, 71);

        jPanel91.add(jPanel123);
        jPanel123.setBounds(-50, 0, 0, 0);

        jPanel131.setBackground(new java.awt.Color(255, 255, 255));
        jPanel131.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel131Layout = new javax.swing.GroupLayout(jPanel131);
        jPanel131.setLayout(jPanel131Layout);
        jPanel131Layout.setHorizontalGroup(
            jPanel131Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 48, Short.MAX_VALUE)
        );
        jPanel131Layout.setVerticalGroup(
            jPanel131Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 48, Short.MAX_VALUE)
        );

        jPanel91.add(jPanel131);
        jPanel131.setBounds(250, 10, 50, 50);

        jPanel132.setBackground(new java.awt.Color(255, 255, 255));
        jPanel132.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel132Layout = new javax.swing.GroupLayout(jPanel132);
        jPanel132.setLayout(jPanel132Layout);
        jPanel132Layout.setHorizontalGroup(
            jPanel132Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 48, Short.MAX_VALUE)
        );
        jPanel132Layout.setVerticalGroup(
            jPanel132Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 48, Short.MAX_VALUE)
        );

        jPanel91.add(jPanel132);
        jPanel132.setBounds(200, 10, 50, 50);

        jPanel133.setBackground(new java.awt.Color(255, 255, 255));
        jPanel133.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel133Layout = new javax.swing.GroupLayout(jPanel133);
        jPanel133.setLayout(jPanel133Layout);
        jPanel133Layout.setHorizontalGroup(
            jPanel133Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 48, Short.MAX_VALUE)
        );
        jPanel133Layout.setVerticalGroup(
            jPanel133Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 48, Short.MAX_VALUE)
        );

        jPanel91.add(jPanel133);
        jPanel133.setBounds(150, 10, 50, 50);

        jPanel134.setBackground(new java.awt.Color(255, 255, 255));
        jPanel134.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel134Layout = new javax.swing.GroupLayout(jPanel134);
        jPanel134.setLayout(jPanel134Layout);
        jPanel134Layout.setHorizontalGroup(
            jPanel134Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 48, Short.MAX_VALUE)
        );
        jPanel134Layout.setVerticalGroup(
            jPanel134Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 48, Short.MAX_VALUE)
        );

        jPanel91.add(jPanel134);
        jPanel134.setBounds(100, 10, 50, 50);

        jPanel135.setBackground(new java.awt.Color(255, 255, 255));
        jPanel135.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel135Layout = new javax.swing.GroupLayout(jPanel135);
        jPanel135.setLayout(jPanel135Layout);
        jPanel135Layout.setHorizontalGroup(
            jPanel135Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 48, Short.MAX_VALUE)
        );
        jPanel135Layout.setVerticalGroup(
            jPanel135Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 48, Short.MAX_VALUE)
        );

        jPanel91.add(jPanel135);
        jPanel135.setBounds(50, 10, 50, 50);

        jPanel136.setBackground(new java.awt.Color(255, 255, 255));
        jPanel136.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel136Layout = new javax.swing.GroupLayout(jPanel136);
        jPanel136.setLayout(jPanel136Layout);
        jPanel136Layout.setHorizontalGroup(
            jPanel136Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 48, Short.MAX_VALUE)
        );
        jPanel136Layout.setVerticalGroup(
            jPanel136Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 48, Short.MAX_VALUE)
        );

        jPanel91.add(jPanel136);
        jPanel136.setBounds(0, 10, 50, 50);

        jPanel137.setBackground(new java.awt.Color(255, 255, 255));
        jPanel137.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel137Layout = new javax.swing.GroupLayout(jPanel137);
        jPanel137.setLayout(jPanel137Layout);
        jPanel137Layout.setHorizontalGroup(
            jPanel137Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 48, Short.MAX_VALUE)
        );
        jPanel137Layout.setVerticalGroup(
            jPanel137Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 48, Short.MAX_VALUE)
        );

        jPanel91.add(jPanel137);
        jPanel137.setBounds(250, 60, 50, 50);

        jPanel138.setBackground(new java.awt.Color(255, 255, 255));
        jPanel138.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel138Layout = new javax.swing.GroupLayout(jPanel138);
        jPanel138.setLayout(jPanel138Layout);
        jPanel138Layout.setHorizontalGroup(
            jPanel138Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 48, Short.MAX_VALUE)
        );
        jPanel138Layout.setVerticalGroup(
            jPanel138Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 48, Short.MAX_VALUE)
        );

        jPanel91.add(jPanel138);
        jPanel138.setBounds(0, 60, 50, 50);

        jPanel139.setBackground(new java.awt.Color(255, 255, 255));
        jPanel139.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel139Layout = new javax.swing.GroupLayout(jPanel139);
        jPanel139.setLayout(jPanel139Layout);
        jPanel139Layout.setHorizontalGroup(
            jPanel139Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 48, Short.MAX_VALUE)
        );
        jPanel139Layout.setVerticalGroup(
            jPanel139Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 48, Short.MAX_VALUE)
        );

        jPanel91.add(jPanel139);
        jPanel139.setBounds(50, 60, 50, 50);

        jPanel140.setBackground(new java.awt.Color(255, 255, 255));
        jPanel140.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel140Layout = new javax.swing.GroupLayout(jPanel140);
        jPanel140.setLayout(jPanel140Layout);
        jPanel140Layout.setHorizontalGroup(
            jPanel140Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 48, Short.MAX_VALUE)
        );
        jPanel140Layout.setVerticalGroup(
            jPanel140Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 48, Short.MAX_VALUE)
        );

        jPanel91.add(jPanel140);
        jPanel140.setBounds(100, 60, 50, 50);

        jPanel141.setBackground(new java.awt.Color(255, 255, 255));
        jPanel141.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel141Layout = new javax.swing.GroupLayout(jPanel141);
        jPanel141.setLayout(jPanel141Layout);
        jPanel141Layout.setHorizontalGroup(
            jPanel141Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 48, Short.MAX_VALUE)
        );
        jPanel141Layout.setVerticalGroup(
            jPanel141Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 48, Short.MAX_VALUE)
        );

        jPanel91.add(jPanel141);
        jPanel141.setBounds(150, 60, 50, 50);

        jPanel142.setBackground(new java.awt.Color(255, 255, 255));
        jPanel142.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel142Layout = new javax.swing.GroupLayout(jPanel142);
        jPanel142.setLayout(jPanel142Layout);
        jPanel142Layout.setHorizontalGroup(
            jPanel142Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 48, Short.MAX_VALUE)
        );
        jPanel142Layout.setVerticalGroup(
            jPanel142Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 48, Short.MAX_VALUE)
        );

        jPanel91.add(jPanel142);
        jPanel142.setBounds(200, 60, 50, 50);

        jPanel147.setBackground(new java.awt.Color(255, 255, 255));
        jPanel147.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel147Layout = new javax.swing.GroupLayout(jPanel147);
        jPanel147.setLayout(jPanel147Layout);
        jPanel147Layout.setHorizontalGroup(
            jPanel147Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 73, Short.MAX_VALUE)
        );
        jPanel147Layout.setVerticalGroup(
            jPanel147Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 118, Short.MAX_VALUE)
        );

        jPanel91.add(jPanel147);
        jPanel147.setBounds(225, 0, 75, 120);

        jPanel148.setBackground(new java.awt.Color(255, 255, 255));
        jPanel148.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel148Layout = new javax.swing.GroupLayout(jPanel148);
        jPanel148.setLayout(jPanel148Layout);
        jPanel148Layout.setHorizontalGroup(
            jPanel148Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 73, Short.MAX_VALUE)
        );
        jPanel148Layout.setVerticalGroup(
            jPanel148Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 118, Short.MAX_VALUE)
        );

        jPanel91.add(jPanel148);
        jPanel148.setBounds(150, 0, 75, 120);

        jPanel149.setBackground(new java.awt.Color(255, 255, 255));
        jPanel149.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel149Layout = new javax.swing.GroupLayout(jPanel149);
        jPanel149.setLayout(jPanel149Layout);
        jPanel149Layout.setHorizontalGroup(
            jPanel149Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 73, Short.MAX_VALUE)
        );
        jPanel149Layout.setVerticalGroup(
            jPanel149Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 118, Short.MAX_VALUE)
        );

        jPanel91.add(jPanel149);
        jPanel149.setBounds(75, 0, 75, 120);

        jPanel150.setBackground(new java.awt.Color(255, 255, 255));
        jPanel150.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel150Layout = new javax.swing.GroupLayout(jPanel150);
        jPanel150.setLayout(jPanel150Layout);
        jPanel150Layout.setHorizontalGroup(
            jPanel150Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 73, Short.MAX_VALUE)
        );
        jPanel150Layout.setVerticalGroup(
            jPanel150Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 118, Short.MAX_VALUE)
        );

        jPanel91.add(jPanel150);
        jPanel150.setBounds(0, 0, 75, 120);

        distributionPanel.add(jPanel91, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 360, 300, 120));

        jPanel101.setBackground(new java.awt.Color(204, 204, 204));
        jPanel101.setLayout(null);

        jPanel102.setBackground(new java.awt.Color(255, 255, 255));
        jPanel102.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel102Layout = new javax.swing.GroupLayout(jPanel102);
        jPanel102.setLayout(jPanel102Layout);
        jPanel102Layout.setHorizontalGroup(
            jPanel102Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 48, Short.MAX_VALUE)
        );
        jPanel102Layout.setVerticalGroup(
            jPanel102Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 69, Short.MAX_VALUE)
        );

        jPanel101.add(jPanel102);
        jPanel102.setBounds(0, 30, 50, 71);

        jPanel103.setBackground(new java.awt.Color(255, 255, 255));
        jPanel103.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel103.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel103MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel103Layout = new javax.swing.GroupLayout(jPanel103);
        jPanel103.setLayout(jPanel103Layout);
        jPanel103Layout.setHorizontalGroup(
            jPanel103Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 48, Short.MAX_VALUE)
        );
        jPanel103Layout.setVerticalGroup(
            jPanel103Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel101.add(jPanel103);
        jPanel103.setBounds(50, 30, 50, 71);

        jPanel104.setBackground(new java.awt.Color(255, 255, 255));
        jPanel104.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel105Layout = new javax.swing.GroupLayout(jPanel105);
        jPanel105.setLayout(jPanel105Layout);
        jPanel105Layout.setHorizontalGroup(
            jPanel105Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel105Layout.setVerticalGroup(
            jPanel105Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel104Layout = new javax.swing.GroupLayout(jPanel104);
        jPanel104.setLayout(jPanel104Layout);
        jPanel104Layout.setHorizontalGroup(
            jPanel104Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 48, Short.MAX_VALUE)
        );
        jPanel104Layout.setVerticalGroup(
            jPanel104Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 69, Short.MAX_VALUE)
        );

        jPanel101.add(jPanel104);
        jPanel104.setBounds(150, 30, 50, 71);

        jPanel106.setBackground(new java.awt.Color(255, 255, 255));
        jPanel106.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel106Layout = new javax.swing.GroupLayout(jPanel106);
        jPanel106.setLayout(jPanel106Layout);
        jPanel106Layout.setHorizontalGroup(
            jPanel106Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 48, Short.MAX_VALUE)
        );
        jPanel106Layout.setVerticalGroup(
            jPanel106Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 69, Short.MAX_VALUE)
        );

        jPanel101.add(jPanel106);
        jPanel106.setBounds(100, 30, 50, 71);

        jPanel107.setBackground(new java.awt.Color(255, 255, 255));
        jPanel107.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel108Layout = new javax.swing.GroupLayout(jPanel108);
        jPanel108.setLayout(jPanel108Layout);
        jPanel108Layout.setHorizontalGroup(
            jPanel108Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel108Layout.setVerticalGroup(
            jPanel108Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel107Layout = new javax.swing.GroupLayout(jPanel107);
        jPanel107.setLayout(jPanel107Layout);
        jPanel107Layout.setHorizontalGroup(
            jPanel107Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 48, Short.MAX_VALUE)
        );
        jPanel107Layout.setVerticalGroup(
            jPanel107Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 69, Short.MAX_VALUE)
        );

        jPanel101.add(jPanel107);
        jPanel107.setBounds(300, 30, 50, 71);

        jPanel109.setBackground(new java.awt.Color(255, 255, 255));
        jPanel109.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel109Layout = new javax.swing.GroupLayout(jPanel109);
        jPanel109.setLayout(jPanel109Layout);
        jPanel109Layout.setHorizontalGroup(
            jPanel109Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 48, Short.MAX_VALUE)
        );
        jPanel109Layout.setVerticalGroup(
            jPanel109Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 69, Short.MAX_VALUE)
        );

        jPanel101.add(jPanel109);
        jPanel109.setBounds(250, 30, 50, 71);

        jPanel110.setBackground(new java.awt.Color(255, 255, 255));
        jPanel110.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel110Layout = new javax.swing.GroupLayout(jPanel110);
        jPanel110.setLayout(jPanel110Layout);
        jPanel110Layout.setHorizontalGroup(
            jPanel110Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 48, Short.MAX_VALUE)
        );
        jPanel110Layout.setVerticalGroup(
            jPanel110Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel101.add(jPanel110);
        jPanel110.setBounds(200, 30, 50, 71);

        jPanel97.setBackground(new java.awt.Color(255, 255, 255));
        jPanel97.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel97Layout = new javax.swing.GroupLayout(jPanel97);
        jPanel97.setLayout(jPanel97Layout);
        jPanel97Layout.setHorizontalGroup(
            jPanel97Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 48, Short.MAX_VALUE)
        );
        jPanel97Layout.setVerticalGroup(
            jPanel97Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 48, Short.MAX_VALUE)
        );

        jPanel101.add(jPanel97);
        jPanel97.setBounds(0, 10, 50, 50);

        jPanel98.setBackground(new java.awt.Color(255, 255, 255));
        jPanel98.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel98Layout = new javax.swing.GroupLayout(jPanel98);
        jPanel98.setLayout(jPanel98Layout);
        jPanel98Layout.setHorizontalGroup(
            jPanel98Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 48, Short.MAX_VALUE)
        );
        jPanel98Layout.setVerticalGroup(
            jPanel98Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 48, Short.MAX_VALUE)
        );

        jPanel101.add(jPanel98);
        jPanel98.setBounds(50, 10, 50, 50);

        jPanel111.setBackground(new java.awt.Color(255, 255, 255));
        jPanel111.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel111Layout = new javax.swing.GroupLayout(jPanel111);
        jPanel111.setLayout(jPanel111Layout);
        jPanel111Layout.setHorizontalGroup(
            jPanel111Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 48, Short.MAX_VALUE)
        );
        jPanel111Layout.setVerticalGroup(
            jPanel111Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 48, Short.MAX_VALUE)
        );

        jPanel101.add(jPanel111);
        jPanel111.setBounds(150, 10, 50, 50);

        jPanel112.setBackground(new java.awt.Color(255, 255, 255));
        jPanel112.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel112Layout = new javax.swing.GroupLayout(jPanel112);
        jPanel112.setLayout(jPanel112Layout);
        jPanel112Layout.setHorizontalGroup(
            jPanel112Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 48, Short.MAX_VALUE)
        );
        jPanel112Layout.setVerticalGroup(
            jPanel112Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 48, Short.MAX_VALUE)
        );

        jPanel101.add(jPanel112);
        jPanel112.setBounds(100, 10, 50, 50);

        jPanel113.setBackground(new java.awt.Color(255, 255, 255));
        jPanel113.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel113Layout = new javax.swing.GroupLayout(jPanel113);
        jPanel113.setLayout(jPanel113Layout);
        jPanel113Layout.setHorizontalGroup(
            jPanel113Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 48, Short.MAX_VALUE)
        );
        jPanel113Layout.setVerticalGroup(
            jPanel113Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 48, Short.MAX_VALUE)
        );

        jPanel101.add(jPanel113);
        jPanel113.setBounds(250, 10, 50, 50);

        jPanel114.setBackground(new java.awt.Color(255, 255, 255));
        jPanel114.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel114Layout = new javax.swing.GroupLayout(jPanel114);
        jPanel114.setLayout(jPanel114Layout);
        jPanel114Layout.setHorizontalGroup(
            jPanel114Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 48, Short.MAX_VALUE)
        );
        jPanel114Layout.setVerticalGroup(
            jPanel114Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 48, Short.MAX_VALUE)
        );

        jPanel101.add(jPanel114);
        jPanel114.setBounds(200, 10, 50, 50);

        jPanel115.setBackground(new java.awt.Color(255, 255, 255));
        jPanel115.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel115Layout = new javax.swing.GroupLayout(jPanel115);
        jPanel115.setLayout(jPanel115Layout);
        jPanel115Layout.setHorizontalGroup(
            jPanel115Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 48, Short.MAX_VALUE)
        );
        jPanel115Layout.setVerticalGroup(
            jPanel115Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 48, Short.MAX_VALUE)
        );

        jPanel101.add(jPanel115);
        jPanel115.setBounds(300, 60, 50, 50);

        jPanel116.setBackground(new java.awt.Color(255, 255, 255));
        jPanel116.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel116Layout = new javax.swing.GroupLayout(jPanel116);
        jPanel116.setLayout(jPanel116Layout);
        jPanel116Layout.setHorizontalGroup(
            jPanel116Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 48, Short.MAX_VALUE)
        );
        jPanel116Layout.setVerticalGroup(
            jPanel116Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 48, Short.MAX_VALUE)
        );

        jPanel101.add(jPanel116);
        jPanel116.setBounds(300, 10, 50, 50);

        jPanel117.setBackground(new java.awt.Color(255, 255, 255));
        jPanel117.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel117Layout = new javax.swing.GroupLayout(jPanel117);
        jPanel117.setLayout(jPanel117Layout);
        jPanel117Layout.setHorizontalGroup(
            jPanel117Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 48, Short.MAX_VALUE)
        );
        jPanel117Layout.setVerticalGroup(
            jPanel117Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 48, Short.MAX_VALUE)
        );

        jPanel101.add(jPanel117);
        jPanel117.setBounds(250, 60, 50, 50);

        jPanel118.setBackground(new java.awt.Color(255, 255, 255));
        jPanel118.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel118Layout = new javax.swing.GroupLayout(jPanel118);
        jPanel118.setLayout(jPanel118Layout);
        jPanel118Layout.setHorizontalGroup(
            jPanel118Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 48, Short.MAX_VALUE)
        );
        jPanel118Layout.setVerticalGroup(
            jPanel118Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 48, Short.MAX_VALUE)
        );

        jPanel101.add(jPanel118);
        jPanel118.setBounds(200, 60, 50, 50);

        jPanel119.setBackground(new java.awt.Color(255, 255, 255));
        jPanel119.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel119Layout = new javax.swing.GroupLayout(jPanel119);
        jPanel119.setLayout(jPanel119Layout);
        jPanel119Layout.setHorizontalGroup(
            jPanel119Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 48, Short.MAX_VALUE)
        );
        jPanel119Layout.setVerticalGroup(
            jPanel119Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 48, Short.MAX_VALUE)
        );

        jPanel101.add(jPanel119);
        jPanel119.setBounds(150, 60, 50, 50);

        jPanel120.setBackground(new java.awt.Color(255, 255, 255));
        jPanel120.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel120Layout = new javax.swing.GroupLayout(jPanel120);
        jPanel120.setLayout(jPanel120Layout);
        jPanel120Layout.setHorizontalGroup(
            jPanel120Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 48, Short.MAX_VALUE)
        );
        jPanel120Layout.setVerticalGroup(
            jPanel120Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 48, Short.MAX_VALUE)
        );

        jPanel101.add(jPanel120);
        jPanel120.setBounds(100, 60, 50, 50);

        jPanel121.setBackground(new java.awt.Color(255, 255, 255));
        jPanel121.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel121Layout = new javax.swing.GroupLayout(jPanel121);
        jPanel121.setLayout(jPanel121Layout);
        jPanel121Layout.setHorizontalGroup(
            jPanel121Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 48, Short.MAX_VALUE)
        );
        jPanel121Layout.setVerticalGroup(
            jPanel121Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 48, Short.MAX_VALUE)
        );

        jPanel101.add(jPanel121);
        jPanel121.setBounds(50, 60, 50, 50);

        jPanel122.setBackground(new java.awt.Color(255, 255, 255));
        jPanel122.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel122Layout = new javax.swing.GroupLayout(jPanel122);
        jPanel122.setLayout(jPanel122Layout);
        jPanel122Layout.setHorizontalGroup(
            jPanel122Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 48, Short.MAX_VALUE)
        );
        jPanel122Layout.setVerticalGroup(
            jPanel122Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 48, Short.MAX_VALUE)
        );

        jPanel101.add(jPanel122);
        jPanel122.setBounds(0, 60, 50, 50);

        jPanel143.setBackground(new java.awt.Color(255, 255, 255));
        jPanel143.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel143Layout = new javax.swing.GroupLayout(jPanel143);
        jPanel143.setLayout(jPanel143Layout);
        jPanel143Layout.setHorizontalGroup(
            jPanel143Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 73, Short.MAX_VALUE)
        );
        jPanel143Layout.setVerticalGroup(
            jPanel143Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 118, Short.MAX_VALUE)
        );

        jPanel101.add(jPanel143);
        jPanel143.setBounds(50, 0, 75, 120);

        jPanel144.setBackground(new java.awt.Color(255, 255, 255));
        jPanel144.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel144Layout = new javax.swing.GroupLayout(jPanel144);
        jPanel144.setLayout(jPanel144Layout);
        jPanel144Layout.setHorizontalGroup(
            jPanel144Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 73, Short.MAX_VALUE)
        );
        jPanel144Layout.setVerticalGroup(
            jPanel144Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 118, Short.MAX_VALUE)
        );

        jPanel101.add(jPanel144);
        jPanel144.setBounds(125, 0, 75, 120);

        jPanel145.setBackground(new java.awt.Color(255, 255, 255));
        jPanel145.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel145Layout = new javax.swing.GroupLayout(jPanel145);
        jPanel145.setLayout(jPanel145Layout);
        jPanel145Layout.setHorizontalGroup(
            jPanel145Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 73, Short.MAX_VALUE)
        );
        jPanel145Layout.setVerticalGroup(
            jPanel145Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 118, Short.MAX_VALUE)
        );

        jPanel101.add(jPanel145);
        jPanel145.setBounds(200, 0, 75, 120);

        jPanel146.setBackground(new java.awt.Color(255, 255, 255));
        jPanel146.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel146Layout = new javax.swing.GroupLayout(jPanel146);
        jPanel146.setLayout(jPanel146Layout);
        jPanel146Layout.setHorizontalGroup(
            jPanel146Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 73, Short.MAX_VALUE)
        );
        jPanel146Layout.setVerticalGroup(
            jPanel146Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 118, Short.MAX_VALUE)
        );

        jPanel101.add(jPanel146);
        jPanel146.setBounds(275, 0, 75, 120);

        distributionPanel.add(jPanel101, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 350, 120));

        jLabel160.setText("0");
        distributionPanel.add(jLabel160, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, -1));

        jLabel38.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel38.setText("FWD");
        distributionPanel.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jLabel161.setText("0");
        distributionPanel.add(jLabel161, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, -1, -1));

        jLabel39.setBackground(new java.awt.Color(204, 204, 0));
        jLabel39.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel39.setText("CTR");
        distributionPanel.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, -1, -1));

        jLabel155.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel155.setText("AFT");
        distributionPanel.add(jLabel155, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, -1, -1));

        jLabel162.setText("0");
        distributionPanel.add(jLabel162, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, -1, -1));

        jLabel156.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel156.setText("PAYLOAD");
        distributionPanel.add(jLabel156, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 10, -1, -1));

        jLabel157.setText("0");
        distributionPanel.add(jLabel157, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 10, -1, 20));

        jLabel158.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel158.setText("UNDER LOAD");
        distributionPanel.add(jLabel158, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 10, -1, -1));

        jLabel159.setText("0");
        distributionPanel.add(jLabel159, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 10, -1, -1));

        javax.swing.GroupLayout jPanel151Layout = new javax.swing.GroupLayout(jPanel151);
        jPanel151.setLayout(jPanel151Layout);
        jPanel151Layout.setHorizontalGroup(
            jPanel151Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel151Layout.createSequentialGroup()
                .addComponent(distributionPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 1500, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        jPanel151Layout.setVerticalGroup(
            jPanel151Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel151Layout.createSequentialGroup()
                .addComponent(distributionPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );

        jScrollPane9.setViewportView(jPanel151);

        jLayeredPane1.add(jScrollPane9, "card12");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Selected Flights");

        jButton7.setBackground(new java.awt.Color(39, 50, 56));
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("Select Flight");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jPanel3.setPreferredSize(new java.awt.Dimension(159, 2700));

        p1.setBackground(new java.awt.Color(102, 102, 102));
        p1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        p1.setPreferredSize(new java.awt.Dimension(140, 100));
        p1.setLayout(new java.awt.GridLayout(0, 1));

        list1.setMargin(new java.awt.Insets(2, 0, 2, 80));
        list1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                list1MouseExited(evt);
            }
        });
        list1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                list1ActionPerformed(evt);
            }
        });
        p1.add(list1);

        p2.setBackground(new java.awt.Color(102, 102, 102));
        p2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        p2.setPreferredSize(new java.awt.Dimension(140, 100));
        p2.setLayout(new java.awt.GridLayout(0, 1));

        list2.setMargin(new java.awt.Insets(2, 0, 2, 80));
        p2.add(list2);

        p3.setBackground(new java.awt.Color(102, 102, 102));
        p3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        p3.setLayout(new java.awt.GridLayout(0, 1));

        list3.setMargin(new java.awt.Insets(2, 0, 2, 80));
        p3.add(list3);

        p4.setBackground(new java.awt.Color(102, 102, 102));
        p4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        p4.setPreferredSize(new java.awt.Dimension(140, 100));
        p4.setLayout(new java.awt.GridLayout(0, 1));

        list4.setMargin(new java.awt.Insets(2, 0, 2, 80));
        p4.add(list4);

        p5.setBackground(new java.awt.Color(102, 102, 102));
        p5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        p5.setPreferredSize(new java.awt.Dimension(140, 100));
        p5.setLayout(new java.awt.GridLayout(0, 1));

        list5.setMargin(new java.awt.Insets(2, 0, 2, 80));
        list5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                list5ActionPerformed(evt);
            }
        });
        p5.add(list5);

        p6.setBackground(new java.awt.Color(102, 102, 102));
        p6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        p6.setPreferredSize(new java.awt.Dimension(140, 100));
        p6.setLayout(new java.awt.GridLayout(0, 1));

        list6.setMargin(new java.awt.Insets(2, 0, 2, 80));
        p6.add(list6);

        p7.setBackground(new java.awt.Color(102, 102, 102));
        p7.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        p7.setLayout(new java.awt.GridLayout(0, 1));

        list7.setMargin(new java.awt.Insets(2, 0, 2, 80));
        p7.add(list7);

        p8.setBackground(new java.awt.Color(102, 102, 102));
        p8.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        p8.setPreferredSize(new java.awt.Dimension(140, 100));
        p8.setLayout(new java.awt.GridLayout(0, 1));

        list8.setMargin(new java.awt.Insets(2, 0, 2, 80));
        list8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                list8ActionPerformed(evt);
            }
        });
        p8.add(list8);

        p9.setBackground(new java.awt.Color(102, 102, 102));
        p9.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        p9.setPreferredSize(new java.awt.Dimension(140, 100));
        p9.setLayout(new java.awt.GridLayout(0, 1));

        list9.setMargin(new java.awt.Insets(2, 0, 2, 80));
        list9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                list9ActionPerformed(evt);
            }
        });
        p9.add(list9);

        p10.setBackground(new java.awt.Color(102, 102, 102));
        p10.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        p10.setPreferredSize(new java.awt.Dimension(140, 100));
        p10.setLayout(new java.awt.GridLayout(0, 1));

        list10.setMargin(new java.awt.Insets(2, 0, 2, 80));
        p10.add(list10);

        p11.setBackground(new java.awt.Color(102, 102, 102));
        p11.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        p11.setLayout(new java.awt.GridLayout(0, 1));

        list11.setMargin(new java.awt.Insets(2, 0, 2, 80));
        p11.add(list11);

        p12.setBackground(new java.awt.Color(102, 102, 102));
        p12.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        p12.setPreferredSize(new java.awt.Dimension(140, 100));
        p12.setLayout(new java.awt.GridLayout(0, 1));

        list12.setMargin(new java.awt.Insets(2, 0, 2, 80));
        p12.add(list12);

        p13.setBackground(new java.awt.Color(102, 102, 102));
        p13.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        p13.setPreferredSize(new java.awt.Dimension(140, 100));
        p13.setLayout(new java.awt.GridLayout(0, 1));

        list13.setMargin(new java.awt.Insets(2, 0, 2, 80));
        list13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                list13ActionPerformed(evt);
            }
        });
        p13.add(list13);

        p14.setBackground(new java.awt.Color(102, 102, 102));
        p14.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        p14.setPreferredSize(new java.awt.Dimension(140, 100));
        p14.setLayout(new java.awt.GridLayout(0, 1));

        list14.setMargin(new java.awt.Insets(2, 0, 2, 80));
        p14.add(list14);

        p15.setBackground(new java.awt.Color(102, 102, 102));
        p15.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        p15.setLayout(new java.awt.GridLayout(0, 1));

        list15.setMargin(new java.awt.Insets(2, 0, 2, 80));
        p15.add(list15);

        p16.setBackground(new java.awt.Color(102, 102, 102));
        p16.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        p16.setPreferredSize(new java.awt.Dimension(140, 100));
        p16.setLayout(new java.awt.GridLayout(0, 1));

        list16.setMargin(new java.awt.Insets(2, 0, 2, 80));
        p16.add(list16);

        p17.setBackground(new java.awt.Color(102, 102, 102));
        p17.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        p17.setPreferredSize(new java.awt.Dimension(140, 100));
        p17.setLayout(new java.awt.GridLayout(0, 1));

        list17.setMargin(new java.awt.Insets(2, 0, 2, 80));
        list17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                list17ActionPerformed(evt);
            }
        });
        p17.add(list17);

        p18.setBackground(new java.awt.Color(102, 102, 102));
        p18.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        p18.setPreferredSize(new java.awt.Dimension(140, 100));
        p18.setLayout(new java.awt.GridLayout(0, 1));

        list18.setMargin(new java.awt.Insets(2, 0, 2, 80));
        p18.add(list18);

        p19.setBackground(new java.awt.Color(102, 102, 102));
        p19.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        p19.setLayout(new java.awt.GridLayout(0, 1));

        list19.setMargin(new java.awt.Insets(2, 0, 2, 80));
        p19.add(list19);

        p20.setBackground(new java.awt.Color(102, 102, 102));
        p20.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        p20.setPreferredSize(new java.awt.Dimension(140, 100));
        p20.setLayout(new java.awt.GridLayout(0, 1));

        list20.setMargin(new java.awt.Insets(2, 0, 2, 80));
        p20.add(list20);

        p21.setBackground(new java.awt.Color(102, 102, 102));
        p21.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        p21.setPreferredSize(new java.awt.Dimension(140, 100));
        p21.setLayout(new java.awt.GridLayout(0, 1));

        list21.setMargin(new java.awt.Insets(2, 0, 2, 80));
        list21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                list21ActionPerformed(evt);
            }
        });
        p21.add(list21);

        p22.setBackground(new java.awt.Color(102, 102, 102));
        p22.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        p22.setPreferredSize(new java.awt.Dimension(140, 100));
        p22.setLayout(new java.awt.GridLayout(0, 1));

        list22.setMargin(new java.awt.Insets(2, 0, 2, 80));
        p22.add(list22);

        p23.setBackground(new java.awt.Color(102, 102, 102));
        p23.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        p23.setLayout(new java.awt.GridLayout(0, 1));

        list23.setMargin(new java.awt.Insets(2, 0, 2, 80));
        p23.add(list23);

        p24.setBackground(new java.awt.Color(102, 102, 102));
        p24.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        p24.setPreferredSize(new java.awt.Dimension(140, 100));
        p24.setLayout(new java.awt.GridLayout(0, 1));

        list24.setMargin(new java.awt.Insets(2, 0, 2, 80));
        p24.add(list24);

        p25.setBackground(new java.awt.Color(102, 102, 102));
        p25.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        p25.setLayout(new java.awt.GridLayout(0, 1));

        list25.setMargin(new java.awt.Insets(2, 0, 2, 80));
        p25.add(list25);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(p3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(p2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                    .addComponent(p1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(p11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(p10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(p9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                    .addComponent(p19, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(p18, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(p17, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                    .addComponent(p8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(p7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(p6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(p5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                    .addComponent(p4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(p16, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(p12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(p15, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(p14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(p13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                    .addComponent(p25, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(p24, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(p20, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(p23, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(p22, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(p21, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(p1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(p2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(p3, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(p4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(p5, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(p6, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(p7, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(p8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(p9, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(p10, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(p11, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(p12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(p13, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(p14, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(p15, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(p16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(p17, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(p18, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(p19, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(p20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(p21, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(p22, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(p23, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(p24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(p25, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(188, Short.MAX_VALUE))
        );

        jScrollPane7.setViewportView(jPanel3);

        javax.swing.GroupLayout jPanel152Layout = new javax.swing.GroupLayout(jPanel152);
        jPanel152.setLayout(jPanel152Layout);
        jPanel152Layout.setHorizontalGroup(
            jPanel152Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel152Layout.setVerticalGroup(
            jPanel152Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 65, Short.MAX_VALUE)
        );

        timeClock.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        timeClock.setForeground(new java.awt.Color(204, 0, 0));
        timeClock.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        timeClock.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        timeClock.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                timeClockMouseClicked(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        buttonGroup.add(hour24);
        hour24.setText("24 hour");
        hour24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hour24ActionPerformed(evt);
            }
        });

        buttonGroup.add(hour12);
        hour12.setSelected(true);
        hour12.setText("12 hour");
        hour12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hour12ActionPerformed(evt);
            }
        });

        jLabel6.setText("Time Format");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(hour24))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(hour12, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel6)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGap(5, 5, 5)
                .addComponent(hour24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(hour12)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(jPanel152, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(timeClock, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(6, 6, 6)
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(timeClock, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jPanel152, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jLabel3)
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void closebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closebtnActionPerformed
        // TODO add your handling code here:

        int r = JOptionPane.showConfirmDialog(this, "Click Yes to Exit", "Exit", JOptionPane.YES_NO_OPTION);
        if (r == 0) {
            System.exit(0);
        }
    }//GEN-LAST:event_closebtnActionPerformed

    private void closebtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closebtnMousePressed
        // TODO add your handling code here:

    }//GEN-LAST:event_closebtnMousePressed

    private void minimizebtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizebtnMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_minimizebtnMousePressed

    private void minimizebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minimizebtnActionPerformed
        // TODO add your handling code here:
        setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_minimizebtnActionPerformed

    private void closebtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closebtnMouseEntered
        // TODO add your handling code here:

        closebtn.setBackground(Color.red);
    }//GEN-LAST:event_closebtnMouseEntered

    private void closebtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closebtnMouseExited
        // TODO add your handling code here:
        closebtn.setBackground(new Color(21, 21, 32));
    }//GEN-LAST:event_closebtnMouseExited

    private void minimizebtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizebtnMouseEntered
        // TODO add your handling code here:

        minimizebtn.setBackground(Color.red);
    }//GEN-LAST:event_minimizebtnMouseEntered

    private void minimizebtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizebtnMouseExited
        // TODO add your handling code here:
        minimizebtn.setBackground(new Color(21, 21, 32));
    }//GEN-LAST:event_minimizebtnMouseExited

    private void fullbtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fullbtnMouseEntered
        // TODO add your handling code here:
        fullbtn.setBackground(Color.red);

    }//GEN-LAST:event_fullbtnMouseEntered

    private void fullbtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fullbtnMouseExited
        // TODO add your handling code here:

        fullbtn.setBackground(new Color(21, 21, 32));
    }//GEN-LAST:event_fullbtnMouseExited

    private void fullbtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fullbtnMousePressed
        // TODO add your handling code here:

        if (FlightInfo.this.getExtendedState() == MAXIMIZED_BOTH) {
            FlightInfo.this.setExtendedState(JFrame.NORMAL);
        } else {
            FlightInfo.this.setExtendedState(MAXIMIZED_BOTH);
        }
    }//GEN-LAST:event_fullbtnMousePressed

    private void fullbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fullbtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fullbtnActionPerformed

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        // TODO add your handling code here:

        x = evt.getX();
        y = evt.getY();

    }//GEN-LAST:event_jPanel1MousePressed

    private void jPanel1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseMoved
        // TODO add your handling code here:


    }//GEN-LAST:event_jPanel1MouseMoved

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
        // TODO add your handling code here:
        int xx = evt.getXOnScreen();
        int yy = evt.getYOnScreen();
        this.setLocation(xx - x, yy - y);
    }//GEN-LAST:event_jPanel1MouseDragged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        title.setText("Flight Info");
        switchPanels(flightInfoPanel);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        title.setText("Flight Creator");
        switchPanels(flightCreatorPanel);

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        title.setText("DeadLoad");
        switchPanels(deadloadPanel);

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        title.setText("Distribution");
        switchPanels1(jScrollPane9);

    }//GEN-LAST:event_jButton5ActionPerformed

    private void moreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moreActionPerformed
        // TODO add your handling code here:
        if (more.getSelectedIndex() == 1) {
            ChangePassword ob1 = new ChangePassword();
            ob1.setVisible(true);
        }
        if (more.getSelectedIndex() == 2) {
            title.setText("Documents");
            switchPanels(documentsPanel);
        }
        if (more.getSelectedIndex() == 3) {
            title.setText("Leteral Imbalance");
            switchPanels(leteralImbalancePanel);
        }
        if (more.getSelectedIndex() == 4) {
            title.setText("LMC");
            switchPanels(lmcPanel);
        }
        more.setSelectedIndex(0);

    }//GEN-LAST:event_moreActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        title.setText("Flight Info Edit");
        switchPanels(flighteditPanel1);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        title.setText("Fuel");
        switchPanels(fuelPanel);


    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseEntered
        // TODO add your handling code here:
        jButton1.setBackground(new Color(39, 50, 56, 50));


    }//GEN-LAST:event_jButton1MouseEntered

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
        // TODO add your handling code here:

        int r = JOptionPane.showConfirmDialog(this, "Are you Sure you want to Logout?", "LOGOUT", JOptionPane.YES_NO_OPTION);
        if (r == 0) {
            this.setVisible(false);
            new LoginPage().setVisible(true);
        }
    }//GEN-LAST:event_logoutActionPerformed

    private void logoutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutMouseEntered
        // TODO add your handling code here:
        logout.setBackground(Color.green);
    }//GEN-LAST:event_logoutMouseEntered

    private void logoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_logoutMouseClicked

    private void logoutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutMouseExited
        // TODO add your handling code here:
        logout.setBackground(new Color(214, 217, 223));


    }//GEN-LAST:event_logoutMouseExited

    private void logoutMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutMousePressed
        // TODO add your handling code here:

    }//GEN-LAST:event_logoutMousePressed

    private void f_dest1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_f_dest1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_f_dest1ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:

        title.setText("Select Flight");
        switchPanels(selectFlightPanel);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void check1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_check1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_check1ActionPerformed

    private void check3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_check3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_check3ActionPerformed

    private void check4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_check4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_check4ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        // TODO add your handling code here:

        DefaultTableModel DFT = (DefaultTableModel) deadload1.getModel();
        String r = "" + route.getText().charAt(4) + "" + route.getText().charAt(5) + "" + route.getText().charAt(6) + "";
        DFT.insertRow(0, new Object[]{"", "0", "0", "0", "0", "" + r + "", "C", "", "", false, false, "", ""});

        deadload1.setRowSelectionInterval(0, 0);
        countRow++;

    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        // TODO add your handling code here:
        if (deadload1.getSelectedRow() < countRow) {
            countRow--;
        }

        DefaultTableModel model = (DefaultTableModel) deadload1.getModel();

        //Delete Selected Row        
        int getSelectedRowForDeletion = deadload1.getSelectedRow();
        //Check if their is a row selected
        if (getSelectedRowForDeletion >= 0) {
            model.removeRow(getSelectedRowForDeletion);

            JOptionPane.showMessageDialog(null, "Row Deleted");
        } else {
            JOptionPane.showMessageDialog(null, "Unable To Delete");
        }

        int i = deadload1.getSelectedRow();
        deadload1.removeAll();
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton20ActionPerformed

    private void block_fActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_block_fActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_block_fActionPerformed

    private void jButton25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton25ActionPerformed
        // TODO add your handling code here:

        try {

            if (block_i.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Please Enter Correct Block Fuel Weight\n from the Standard index Fuel Table");
                return;
            }

            if (trip_i.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Please Enter Correct Trip Fuel Weight\n from the Standard index Fuel Table");
                return;
            }
            if (unusable_i.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Please Enter Correct Unusable Fuel Weight\n from the Standard index Fuel Table");
                return;
            }

            String f_d_c = (String) fuel_distri_combo.getSelectedItem();
            String d_c = (String) density_combo.getSelectedItem();
            con = Connect.ConnectDB();
            String sql2 = "SELECT * FROM newFlight where Active = 'yes'";

            pst = con.prepareStatement(sql2);
            String FLT = "";
            rs = pst.executeQuery();
            while (rs.next()) {
                FLT = rs.getString("FLT_NO");
                String sql3 = "SELECT * FROM fuelInfo where FLT_NO ='" + FLT + "'";
                pst = con.prepareStatement(sql3);
                rs = pst.executeQuery();
                break;
            }

            while (rs.next()) {
                String sq4 = "UPDATE fuelInfo SET fuel_distribution = '" + f_d_c + "', block_fuel = '" + Integer.parseInt(block_f.getText()) + "',block_fuel_index= '" + block_i.getText() + "',trip_fuel='" + Integer.parseInt(trip_f.getText()) + "',trip_fuel_index='" + trip_i.getText() + "',unusable_fuel= '" + Integer.parseInt(unusable_f.getText()) + "',unusable_fuel_index ='" + unusable_i.getText() + "',taxi_fuel ='" + Integer.parseInt(taxi_f.getText()) + "', density= '" + d_c + "' WHERE FLT_NO = '" + FLT + "'";
                pst = con.prepareStatement(sq4);
                pst.execute();
                JOptionPane.showMessageDialog(null, "Fuel Info Update successfully");

                title.setText("Flight Info");
                switchPanels(flightInfoPanel);
                displayFuelInfo();

                return;
            }

            pst = null;
            rs = null;

            String sql = "insert into fuelInfo values('" + flight1 + "','" + f_d_c + "','" + Integer.parseInt(block_f.getText()) + "','" + block_i.getText() + "','" + Integer.parseInt(trip_f.getText()) + "','" + trip_i.getText() + "','" + Integer.parseInt(unusable_f.getText()) + "','" + unusable_i.getText() + "','" + Integer.parseInt(taxi_f.getText()) + "','" + d_c + "')";

            pst = con.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Fuel Apply successfully");

            title.setText("Flight Info");
            switchPanels(flightInfoPanel);

            displayFuelInfo();

            //resetFlightCreatorFields();//reset all fiels of flight creator tab
        } catch (HeadlessException | SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);
        } // TODO Auto-generated catch block
        catch (NumberFormatException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButton25ActionPerformed

    private void CFG_panelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CFG_panelMouseEntered
        // TODO add your handling code here:

    }//GEN-LAST:event_CFG_panelMouseEntered

    private void CFG_panelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CFG_panelMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_CFG_panelMouseExited

    private void FJG_panelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FJG_panelMouseEntered
        // TODO add your handling code here:

    }//GEN-LAST:event_FJG_panelMouseEntered

    private void FJG_panelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FJG_panelMouseExited
        // TODO add your handling code here:

    }//GEN-LAST:event_FJG_panelMouseExited

    private void JLG_panelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JLG_panelMouseExited
        // TODO add your handling code here:

    }//GEN-LAST:event_JLG_panelMouseExited

    private void LPR_panelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LPR_panelMouseExited
        // TODO add your handling code here:

    }//GEN-LAST:event_LPR_panelMouseExited

    private void JLG_panelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JLG_panelMouseEntered
        // TODO add your handling code here:

    }//GEN-LAST:event_JLG_panelMouseEntered

    private void LPR_panelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LPR_panelMouseEntered
        // TODO add your handling code here:


    }//GEN-LAST:event_LPR_panelMouseEntered

    private void JLR_panelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JLR_panelMouseExited
        // TODO add your handling code here:

    }//GEN-LAST:event_JLR_panelMouseExited

    private void FJR_panelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FJR_panelMouseEntered
        // TODO add your handling code here:


    }//GEN-LAST:event_FJR_panelMouseEntered

    private void FJR_panelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FJR_panelMouseExited
        // TODO add your handling code here:

    }//GEN-LAST:event_FJR_panelMouseExited

    private void CFR_panelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CFR_panelMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_CFR_panelMouseExited

    private void JLR_panelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JLR_panelMouseEntered
        // TODO add your handling code here:

    }//GEN-LAST:event_JLR_panelMouseEntered

    private void CFR_panelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CFR_panelMouseEntered
        // TODO add your handling code here:

    }//GEN-LAST:event_CFR_panelMouseEntered

    private void jButton2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseEntered
        // TODO add your handling code here:
        jButton2.setBackground(new Color(39, 50, 56, 50));
    }//GEN-LAST:event_jButton2MouseEntered

    private void jButton3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseEntered
        // TODO add your handling code here:
        jButton3.setBackground(new Color(39, 50, 56, 50));
    }//GEN-LAST:event_jButton3MouseEntered

    private void jButton4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseEntered
        // TODO add your handling code here:
        jButton4.setBackground(new Color(39, 50, 56, 50));
    }//GEN-LAST:event_jButton4MouseEntered

    private void jButton5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseEntered
        // TODO add your handling code here:
        jButton5.setBackground(new Color(39, 50, 56, 50));
    }//GEN-LAST:event_jButton5MouseEntered

    private void jButton6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseEntered
        // TODO add your handling code here:
        jButton6.setBackground(new Color(39, 50, 56, 50));
    }//GEN-LAST:event_jButton6MouseEntered

    private void moreMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_moreMouseEntered
        // TODO add your handling code here:
        more.setBackground(new Color(39, 50, 56, 50));
    }//GEN-LAST:event_moreMouseEntered

    private void jButton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseExited
        // TODO add your handling code here:

        //  jButton1.setBackground(new Color(60,63,65,10));
    }//GEN-LAST:event_jButton1MouseExited

    private void jCheckBox5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox5ActionPerformed
        // TODO add your handling code here:

        if (jCheckBox5.isSelected() == true) {

            jTextField1.setEditable(true);
            jTextField20.setEditable(true);
        }

        if (jCheckBox5.isSelected() == false) {

            jTextField1.setEditable(false);
            jTextField20.setEditable(false);
            jTextField1.setText("");
            jTextField20.setText("");

        }
    }//GEN-LAST:event_jCheckBox5ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton24ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton24ActionPerformed

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton22ActionPerformed

    private void jTextField16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField16ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField16ActionPerformed

    private void FJGMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FJGMouseEntered
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        char findSymbol = lbel.getText().charAt(0);

        if (findSymbol != '<') {
            lbel.setText("N");
        }
        if (lbel.getText().equals("N")) {

            random(lbel);
        }
        deadload2.getSelectionModel().clearSelection();
    }//GEN-LAST:event_FJGMouseEntered

    private void CFGMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CFGMouseEntered

        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        char findSymbol = lbel.getText().charAt(0);

        if (findSymbol != '<') {
            lbel.setText("N");
        }
        if (lbel.getText().equals("N")) {

            random(lbel);
        }
        deadload2.getSelectionModel().clearSelection();
    }//GEN-LAST:event_CFGMouseEntered

    private void FJGMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FJGMouseReleased
        // TODO add your handling code here:
        check = 1;

    }//GEN-LAST:event_FJGMouseReleased

    private void FJGMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FJGMousePressed
        // TODO add your handling code here:
        temp = FJG.getText();

        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        pressExitDrag(lbel, "text");


    }//GEN-LAST:event_FJGMousePressed

    private void CFGMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CFGMousePressed
        // TODO add your handling code here:
        temp = CFG.getText();

        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        pressExitDrag(lbel, "text");
    }//GEN-LAST:event_CFGMousePressed

    private void density_comboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_density_comboActionPerformed

        block_f.setText("");
        taxi_f.setText("");
        trip_f.setText("");
        unusable_f.setText("");
        block_i.setText("");
        trip_i.setText("");
        unusable_i.setText("");
    }//GEN-LAST:event_density_comboActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        // TODO add your handling code here:

        try {
            con = Connect.ConnectDB();
            String sql2 = "SELECT * FROM newFlight where Active = 'yes' ";
            pst = con.prepareStatement(sql2);
            rs = pst.executeQuery();

            while (rs.next()) {
                String f = rs.getString("Active");

                if ("yes".equals(f)) {
                    JOptionPane.showMessageDialog(this, "One Flight is already Loaded. Please wait until the flight is unloaded", "Alert", JOptionPane.WARNING_MESSAGE);
                    return;
                }
            }
            pst = null;
            rs = null;
            String fix = "";
            if (check1.isSelected()) {

                fix = flight1;
            } else if (check2.isSelected()) {

                fix = flight2;
            } else if (check3.isSelected()) {
                fix = flight3;
            } else if (check4.isSelected()) {
                fix = flight4;
            } else if (check5.isSelected()) {
                fix = flight5;
            } else if (check6.isSelected()) {
                fix = flight6;
            } else if (check7.isSelected()) {
                fix = flight7;

            } else if (check8.isSelected()) {
                fix = flight8;

            } else if (check9.isSelected()) {
                fix = flight9;

            } else if (check10.isSelected()) {
                fix = flight10;

            } else if (check11.isSelected()) {
                fix = flight11;

            } else if (check12.isSelected()) {
                fix = flight12;
            } else if (check13.isSelected()) {
                fix = flight13;
            } else if (check14.isSelected()) {
                fix = flight14;

            } else if (check15.isSelected()) {
                fix = flight15;
            } else if (check16.isSelected()) {
                fix = flight16;
            } else if (check17.isSelected()) {
                fix = flight17;
            } else if (check18.isSelected()) {
                fix = flight18;

            } else if (check19.isSelected()) {
                fix = flight19;

            } else if (check20.isSelected()) {
                fix = flight20;

            } else if (check21.isSelected()) {
                fix = flight21;

            } else if (check22.isSelected()) {
                fix = flight22;
            } else if (check23.isSelected()) {
                fix = flight23;

            } else if (check24.isSelected()) {
                fix = flight24;

            } else if (check25.isSelected()) {
                fix = flight25;

            }
            String sql = "update newFlight set Active ='yes' where FLT_NO='" + fix + "'";
            pst = con.prepareStatement(sql);
            pst.execute();

            title.setText("Flight Info");
            switchPanels(flightInfoPanel);

            showInfoFlightData();
            pst = null;
            rs = null;
            String sql5 = "SELECT * FROM [weight Correction] where FLT_NO ='" + fix + "'";
            pst = con.prepareStatement(sql5);
            rs = pst.executeQuery();
            String g = "";
            while (rs.next()) {
                g = rs.getString("REGISTRATION");

            }

            regCombo.setSelectedItem(g);
            list1.setBackground(new Color(255, 102, 0));

            cycle();

            setDOW_I();

            deadload_update();
            deadload_update_distribution();
            updateMainDeck();
        } catch (SQLException ex) {
            Logger.getLogger(FlightInfo.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_jButton14ActionPerformed

    private void unloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unloadActionPerformed
        // TODO add your handling code here:

        try {
            con = Connect.ConnectDB();

            String fix = "";
            if (check1.isSelected()) {

                String sql1 = "select * from newFlight where Active ='no' and Flt_No = '" + flight1 + "'";
                pst = con.prepareStatement(sql1);
                rs = pst.executeQuery();
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "The flight = '" + flight1 + "' is Already UnLoad.", "Error", JOptionPane.ERROR_MESSAGE);

                    return;

                }

                fix = flight1;
            } else if (check2.isSelected()) {

                String sql1 = "select * from newFlight where Active ='no' and Flt_No = '" + flight2 + "'";
                pst = con.prepareStatement(sql1);
                rs = pst.executeQuery();
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "The flight = '" + flight2 + "' is Already UnLoad.", "Error", JOptionPane.ERROR_MESSAGE);

                    return;

                }
                fix = flight2;
            } else if (check3.isSelected()) {

                String sql1 = "select * from newFlight where Active ='no' and Flt_No = '" + flight3 + "'";
                pst = con.prepareStatement(sql1);
                rs = pst.executeQuery();
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "The flight = '" + flight3 + "' is Already UnLoad.", "Error", JOptionPane.ERROR_MESSAGE);

                    return;

                }
                fix = flight3;
            } else if (check4.isSelected()) {

                String sql1 = "select * from newFlight where Active ='no' and Flt_No = '" + flight4 + "'";
                pst = con.prepareStatement(sql1);
                rs = pst.executeQuery();
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "The flight = '" + flight4 + "' is Already UnLoad.", "Error", JOptionPane.ERROR_MESSAGE);

                    return;

                }
                fix = flight4;
            } else if (check5.isSelected()) {

                String sql1 = "select * from newFlight where Active ='no' and Flt_No = '" + flight5 + "'";
                pst = con.prepareStatement(sql1);
                rs = pst.executeQuery();
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "The flight = '" + flight5 + "' is Already UnLoad.", "Error", JOptionPane.ERROR_MESSAGE);

                    return;

                }
                fix = flight5;
            } else if (check6.isSelected()) {

                String sql1 = "select * from newFlight where Active ='no' and Flt_No = '" + flight6 + "'";
                pst = con.prepareStatement(sql1);
                rs = pst.executeQuery();
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "The flight = '" + flight6 + "' is Already UnLoad.", "Error", JOptionPane.ERROR_MESSAGE);

                    return;

                }
                fix = flight6;
            } else if (check7.isSelected()) {

                String sql1 = "select * from newFlight where Active ='no' and Flt_No = '" + flight7 + "'";
                pst = con.prepareStatement(sql1);
                rs = pst.executeQuery();
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "The flight = '" + flight7 + "' is Already UnLoad.", "Error", JOptionPane.ERROR_MESSAGE);

                    return;

                }
                fix = flight7;

            } else if (check8.isSelected()) {

                String sql1 = "select * from newFlight where Active ='no' and Flt_No = '" + flight8 + "'";
                pst = con.prepareStatement(sql1);
                rs = pst.executeQuery();
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "The flight = '" + flight8 + "' is Already UnLoad.", "Error", JOptionPane.ERROR_MESSAGE);

                    return;

                }
                fix = flight8;

            } else if (check9.isSelected()) {

                String sql1 = "select * from newFlight where Active ='no' and Flt_No = '" + flight9 + "'";
                pst = con.prepareStatement(sql1);
                rs = pst.executeQuery();
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "The flight = '" + flight9 + "' is Already UnLoad.", "Error", JOptionPane.ERROR_MESSAGE);

                    return;

                }
                fix = flight9;

            } else if (check10.isSelected()) {

                String sql1 = "select * from newFlight where Active ='no' and Flt_No = '" + flight10 + "'";
                pst = con.prepareStatement(sql1);
                rs = pst.executeQuery();
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "The flight = '" + flight10 + "' is Already UnLoad.", "Error", JOptionPane.ERROR_MESSAGE);

                    return;

                }
                fix = flight10;

            } else if (check11.isSelected()) {

                String sql1 = "select * from newFlight where Active ='no' and Flt_No = '" + flight11 + "'";
                pst = con.prepareStatement(sql1);
                rs = pst.executeQuery();
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "The flight = '" + flight11 + "' is Already UnLoad.", "Error", JOptionPane.ERROR_MESSAGE);

                    return;

                }
                fix = flight11;

            } else if (check12.isSelected()) {

                String sql1 = "select * from newFlight where Active ='no' and Flt_No = '" + flight12 + "'";
                pst = con.prepareStatement(sql1);
                rs = pst.executeQuery();
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "The flight = '" + flight12 + "' is Already UnLoad.", "Error", JOptionPane.ERROR_MESSAGE);

                    return;

                }
                fix = flight12;
            } else if (check13.isSelected()) {

                String sql1 = "select * from newFlight where Active ='no' and Flt_No = '" + flight13 + "'";
                pst = con.prepareStatement(sql1);
                rs = pst.executeQuery();
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "The flight = '" + flight13 + "' is Already UnLoad.", "Error", JOptionPane.ERROR_MESSAGE);

                    return;

                }
                fix = flight13;
            } else if (check14.isSelected()) {

                String sql1 = "select * from newFlight where Active ='no' and Flt_No = '" + flight14 + "'";
                pst = con.prepareStatement(sql1);
                rs = pst.executeQuery();
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "The flight = '" + flight14 + "' is Already UnLoad.", "Error", JOptionPane.ERROR_MESSAGE);

                    return;

                }
                fix = flight14;

            } else if (check15.isSelected()) {

                String sql1 = "select * from newFlight where Active ='no' and Flt_No = '" + flight15 + "'";
                pst = con.prepareStatement(sql1);
                rs = pst.executeQuery();
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "The flight = '" + flight15 + "' is Already UnLoad.", "Error", JOptionPane.ERROR_MESSAGE);

                    return;

                }
                fix = flight15;
            } else if (check16.isSelected()) {

                String sql1 = "select * from newFlight where Active ='no' and Flt_No = '" + flight16 + "'";
                pst = con.prepareStatement(sql1);
                rs = pst.executeQuery();
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "The flight = '" + flight16 + "' is Already UnLoad.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;

                }
                fix = flight16;
            } else if (check17.isSelected()) {

                String sql1 = "select * from newFlight where Active ='no' and Flt_No = '" + flight17 + "'";
                pst = con.prepareStatement(sql1);
                rs = pst.executeQuery();
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "The flight = '" + flight17 + "' is Already UnLoad.", "Error", JOptionPane.ERROR_MESSAGE);

                    return;

                }
                fix = flight17;
            } else if (check18.isSelected()) {

                String sql1 = "select * from newFlight where Active ='no' and Flt_No = '" + flight18 + "'";
                pst = con.prepareStatement(sql1);
                rs = pst.executeQuery();
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "The flight = '" + flight18 + "' is Already UnLoad.", "Error", JOptionPane.ERROR_MESSAGE);

                    return;

                }
                fix = flight18;

            } else if (check19.isSelected()) {

                String sql1 = "select * from newFlight where Active ='no' and Flt_No = '" + flight19 + "'";
                pst = con.prepareStatement(sql1);
                rs = pst.executeQuery();
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "The flight = '" + flight19 + "' is Already UnLoad.", "Error", JOptionPane.ERROR_MESSAGE);

                    return;

                }
                fix = flight19;

            } else if (check20.isSelected()) {

                String sql1 = "select * from newFlight where Active ='no' and Flt_No = '" + flight20 + "'";
                pst = con.prepareStatement(sql1);
                rs = pst.executeQuery();
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "The flight = '" + flight20 + "' is Already UnLoad.", "Error", JOptionPane.ERROR_MESSAGE);

                    return;

                }
                fix = flight20;

            } else if (check21.isSelected()) {

                String sql1 = "select * from newFlight where Active ='no' and Flt_No = '" + flight21 + "'";
                pst = con.prepareStatement(sql1);
                rs = pst.executeQuery();
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "The flight = '" + flight21 + "' is Already UnLoad.", "Error", JOptionPane.ERROR_MESSAGE);

                    return;

                }
                fix = flight21;

            } else if (check22.isSelected()) {

                String sql1 = "select * from newFlight where Active ='no' and Flt_No = '" + flight22 + "'";
                pst = con.prepareStatement(sql1);
                rs = pst.executeQuery();
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "The flight = '" + flight22 + "' is Already UnLoad.", "Error", JOptionPane.ERROR_MESSAGE);

                    return;

                }
                fix = flight22;
            } else if (check23.isSelected()) {

                String sql1 = "select * from newFlight where Active ='no' and Flt_No = '" + flight23 + "'";
                pst = con.prepareStatement(sql1);
                rs = pst.executeQuery();
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "The flight = '" + flight23 + "' is Already UnLoad.", "Error", JOptionPane.ERROR_MESSAGE);

                    return;

                }
                fix = flight23;

            } else if (check24.isSelected()) {

                String sql1 = "select * from newFlight where Active ='no' and Flt_No = '" + flight24 + "'";
                pst = con.prepareStatement(sql1);
                rs = pst.executeQuery();
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "The flight = '" + flight24 + "' is Already UnLoad.", "Error", JOptionPane.ERROR_MESSAGE);

                    return;

                }
                fix = flight24;

            } else if (check25.isSelected()) {

                String sql1 = "select * from newFlight where Active ='no' and Flt_No = '" + flight25 + "'";
                pst = con.prepareStatement(sql1);
                rs = pst.executeQuery();
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "The flight = '" + flight25 + "' is Already UnLoad.", "Error", JOptionPane.ERROR_MESSAGE);

                    return;

                }
                fix = flight25;

            }
            String sql = "update newFlight set Active ='no' where FLT_NO='" + fix + "'";
            pst = con.prepareStatement(sql);
            pst.execute();
            displayFuelInfo();

            if (check1.isSelected()) {
                regCombo.removeAllItems();
                crewCombo.removeAllItems();
                list1.setBackground(new Color(60, 63, 65));
                ac_type.setText("");
                route.setText("");
                date.setText("");
                std.setText("");
            }

            dow.setText("");
            doi.setText("");

            cycle();

            deadload_update();
            deadload_update_distribution();
            resetMainDeck();

        } catch (SQLException ex) {
            Logger.getLogger(FlightInfo.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_unloadActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
        deadload2.setVisible(false);
        jTable6.setVisible(true);
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
        jTable6.setVisible(false);
        deadload2.setVisible(true);
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton26ActionPerformed
        // TODO add your handling code here:
        setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_jButton26ActionPerformed

    private void jButton27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton27ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton27ActionPerformed

    private void jButton26MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton26MousePressed
        // TODO add your handling code here:

        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_jButton26MousePressed

    private void jButton26MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton26MouseDragged
        // TODO add your handling code here:
        int xx = evt.getXOnScreen();
        int yy = evt.getYOnScreen();
        jButton26.setLocation(xx - x, yy - y);

    }//GEN-LAST:event_jButton26MouseDragged
    public boolean isNum(String s) {
        if (s == null) {
            return false;
        }
        if (s.length() < 4) {
            return false;
        }
        if (s.charAt(0) == '2') {
            if (Character.getNumericValue(s.charAt(1)) > 3) {
                return false;
            }
        }
        if (Character.getNumericValue(s.charAt(3)) > 5) {
            return false;
        }
        //  if (s.charAt(3) == '5') {

        //    if (Character.getNumericValue(s.charAt(4)) > 0) {
        //     return false;
        //}
        //}
        return pattern.matcher(s).matches();
    }
    private void f_createActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_f_createActionPerformed
        // TODO add your handling code here:

        String flt = null;
        con = Connect.ConnectDB();
        try {

            //boolean dd = f_date.getDate().toString().equals("");
            //if () {
            //JOptionPane.showMessageDialog(this, "Please enter Flight No", "Error", JOptionPane.ERROR_MESSAGE);
            // f_date.setBackground(new Color(250,128,114));
            //return;
            //}
            if (f_flight_no.getText().equals("")) {
                //JOptionPane.showMessageDialog(this, "Please enter Flight No", "Error", JOptionPane.ERROR_MESSAGE);
                f_flight_no.setBackground(new Color(250, 128, 114));
                return;
            }
            if (f_org.getText().equals("")) {
                // JOptionPane.showMessageDialog(this, "Please enter orgin", "Error", JOptionPane.ERROR_MESSAGE);
                f_org.setBackground(new Color(250, 128, 114));
                return;
            }
            if (f_dest1.getText().equals("")) {
                //  JOptionPane.showMessageDialog(this, "Please enter Destination.", "Error", JOptionPane.ERROR_MESSAGE);
                f_dest1.setBackground(new Color(250, 128, 114));
                return;
            }
            if (f_std.getText().equals("")) {
                //JOptionPane.showMessageDialog(this, "Please enter STA", "Error", JOptionPane.ERROR_MESSAGE);
                f_std.setBackground(new Color(250, 128, 114));
                return;
            }
            if (!isNum(f_std.getText())) {
                JOptionPane.showMessageDialog(this, "Please Correct STD 24hr Time Format (hh:mm)", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String sql1 = "Select FLT_NO from newFlight where FLT_NO= '" + f_flight_no.getText() + "'";

            pst = con.prepareStatement(sql1);
            rs = pst.executeQuery();

            if (rs.next()) {
                JOptionPane.showMessageDialog(this, "Flight no = " + f_flight_no.getText() + "\nFlight is already exists. Please enter a new flight no", "Error", JOptionPane.ERROR_MESSAGE);
                f_flight_no.setText("");
                f_flight_no.requestDefaultFocus();
                return;
            }
            pst = null;
            rs = null;
            String sql2 = "SELECT * FROM newFlight where Active = 'yes' ";
            pst = con.prepareStatement(sql2);
            rs = pst.executeQuery();

            while (rs.next()) {
                String f = rs.getString("Active");

                if ("yes".equals(f)) {
                    JOptionPane.showMessageDialog(this, "One Flight is already Loaded. Please wait until the flight is unloaded", "Alert", JOptionPane.WARNING_MESSAGE);
                    return;
                }
            }

            if (checkList == 1)//for check All 25 flight are created
            {
                JOptionPane.showMessageDialog(this, "Please Delete atleast One flight", "Warrning", JOptionPane.WARNING_MESSAGE);
                return;
            }

            pst = null;
            rs = null;
            Date d = f_date.getDate();
            SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMMYY");
            String strDate = dateFormat.format(d);
            int r = JOptionPane.showConfirmDialog(this, "Are you Sure you want to create new Flight", "NEW FLIGHT", JOptionPane.YES_NO_CANCEL_OPTION);

            if (r == 0) {
                String sql = "insert into newFlight (DATE,FLT_NO,ORG,DEST1,DEST2,DEST3,STA,AC_TYPE,REG) values('" + strDate + "','" + f_flight_no.getText() + "','" + f_org.getText() + "','" + f_dest1.getText() + "','" + f_dest2.getText() + "','" + f_dest3.getText() + "','" + f_std.getText() + "','" + f_ac.getSelectedItem().toString() + "','" + f_reg.getSelectedItem().toString() + "')";

                pst = con.prepareStatement(sql);
                pst.execute();

                reg = f_reg.getSelectedItem().toString();
                flt = f_flight_no.getText();
                resetFlightCreatorFields();//reset all fiels of flight creator tab
                //  showInfoFlightData();//to show the data in flight info tab
                regCombo.setSelectedItem(reg);
                String sq1 = "insert into [weight Correction] (FLT_NO,REGISTRATION,CREW,DOW,DOI) values('" + flt + "','" + reg + "','2/3',0,'0')";
                pst = con.prepareStatement(sq1);
                pst.execute();
                JOptionPane.showMessageDialog(this, "Record Saved");
            }
        } catch (HeadlessException | SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);
        }   // TODO add your handling code here:

        ConstructorCode();
        reg = null;
    }//GEN-LAST:event_f_createActionPerformed

    private void jTextField20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField20ActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jTextField20ActionPerformed

    private void jTextField1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField1MousePressed
        // TODO add your handling code here:

        if (jCheckBox5.isSelected() == false) {
            JOptionPane.showMessageDialog(this, "Check box is unMarked", "Alert", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jTextField1MousePressed

    private void jTextField20MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField20MousePressed
        // TODO add your handling code here:
        if (jCheckBox5.isSelected() == false) {
            JOptionPane.showMessageDialog(this, "Check box is unMarked", "Alert", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jTextField20MousePressed

    private void block_fKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_block_fKeyTyped
        // TODO add your handling code here:

    }//GEN-LAST:event_block_fKeyTyped

    private void block_fKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_block_fKeyReleased
        block_i.setText("");
        try {
            con = Connect.ConnectDB();
            String sql = "SELECT * FROM [Standard fuel index] where weight = '" + block_f.getText() + "' ";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            String c = (String) density_combo.getSelectedItem();
            float o = Float.parseFloat(c);
            while (rs.next()) {
                float a = rs.getFloat(c);
                String i = Float.toString(a);
                block_i.setText(i);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FlightInfo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_block_fKeyReleased

    private void density_comboMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_density_comboMouseClicked

    }//GEN-LAST:event_density_comboMouseClicked

    private void density_comboMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_density_comboMousePressed
        // TODO add your handling code here:


    }//GEN-LAST:event_density_comboMousePressed

    private void density_comboMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_density_comboMouseEntered
        // TODO add your handling code here:

    }//GEN-LAST:event_density_comboMouseEntered

    private void density_comboMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_density_comboMouseReleased
        // TODO add your handling code here:

    }//GEN-LAST:event_density_comboMouseReleased

    private void density_comboMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_density_comboMouseExited
        // TODO add your handling code here:


    }//GEN-LAST:event_density_comboMouseExited

    private void trip_fKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_trip_fKeyReleased
        // TODO add your handling code here:
        trip_i.setText("");
        try {
            con = Connect.ConnectDB();
            String sql = "SELECT * FROM [Standard fuel index] where weight = '" + trip_f.getText() + "' ";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();

            String c = (String) density_combo.getSelectedItem();
            while (rs.next()) {
                float a = rs.getFloat(c);

                String i = Float.toString(a);
                trip_i.setText(i);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FlightInfo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_trip_fKeyReleased

    private void unusable_fKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_unusable_fKeyReleased

        unusable_i.setText("");
        try {
            con = Connect.ConnectDB();
            String sql = "SELECT * FROM [Standard fuel index] where weight = '" + unusable_f.getText() + "' ";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            String c = (String) density_combo.getSelectedItem();
            while (rs.next()) {
                float a = rs.getFloat(c);
                String i = Float.toString(a);
                unusable_i.setText(i);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FlightInfo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_unusable_fKeyReleased

    private void checkboxMD20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkboxMD20ActionPerformed
        // TODO add your handling code here:
        checkBoxMD20();


    }//GEN-LAST:event_checkboxMD20ActionPerformed

    private void checkboxMD16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkboxMD16ActionPerformed
        // TODO add your handling code here:
        checkBoxMD16();

    }//GEN-LAST:event_checkboxMD16ActionPerformed

    private void checkboxMD3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkboxMD3ActionPerformed
        // TODO add your handling code here:
        checkBoxMD3();

    }//GEN-LAST:event_checkboxMD3ActionPerformed

    private void checkboxMD1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkboxMD1ActionPerformed
        // TODO add your handling code here:
        checkBoxMD1();
    }//GEN-LAST:event_checkboxMD1ActionPerformed

    private void checkboxMD2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkboxMD2ActionPerformed
        // TODO add your handling code here:
        checkBoxMD2();


    }//GEN-LAST:event_checkboxMD2ActionPerformed

    private void f_orgKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_f_orgKeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_f_orgKeyPressed

    private void f_orgKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_f_orgKeyTyped
        // TODO add your handling code here:

    }//GEN-LAST:event_f_orgKeyTyped

    private void f_orgKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_f_orgKeyReleased
        // TODO add your handling code here:
        if (f_org.getText().length() > 4) {
            char f = f_org.getText().charAt(0);
            char s = f_org.getText().charAt(1);
            char t = f_org.getText().charAt(2);
            char fth = f_org.getText().charAt(3);

            f_org.setText("" + f + "" + s + "" + t + "" + fth + "");
            return;
        }
        //  if (f_org.getText().length()>=5) {
        //    JOptionPane.showMessageDialog(this, "Alert\nPlz Enter Maximun 4 Characters");
        //}
    }//GEN-LAST:event_f_orgKeyReleased

    private void f_dest1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_f_dest1KeyReleased
        // TODO add your handling code here:
        if (f_dest1.getText().length() > 4) {
            char f = f_dest1.getText().charAt(0);
            char s = f_dest1.getText().charAt(1);
            char t = f_dest1.getText().charAt(2);
            char fth = f_dest1.getText().charAt(3);

            f_dest1.setText("" + f + "" + s + "" + t + "" + fth + "");
            return;
        }
        // if (f_dest1.getText().length()>=5) {
        //  JOptionPane.showMessageDialog(this, "Alert\nPlz Enter Maximun 4 Characters");
        //}
    }//GEN-LAST:event_f_dest1KeyReleased

    private void f_dest2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_f_dest2KeyReleased
        // TODO add your handling code here:
        if (f_dest2.getText().length() > 4) {
            char f = f_dest2.getText().charAt(0);
            char s = f_dest2.getText().charAt(1);
            char t = f_dest2.getText().charAt(2);
            char fth = f_dest2.getText().charAt(3);

            f_dest2.setText("" + f + "" + s + "" + t + "" + fth + "");
            return;
        }
        //if (f_dest2.getText().length()>=5) {
        //    JOptionPane.showMessageDialog(this, "Alert\nPlz Enter Maximun 4 Characters");
        //}
    }//GEN-LAST:event_f_dest2KeyReleased

    private void f_dest3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_f_dest3KeyReleased
        // TODO add your handling code here:
        if (f_dest3.getText().length() > 4) {
            char f = f_dest3.getText().charAt(0);
            char s = f_dest3.getText().charAt(1);
            char t = f_dest3.getText().charAt(2);
            char fth = f_dest3.getText().charAt(3);

            f_dest3.setText("" + f + "" + s + "" + t + "" + fth + "");
            return;
        }
//if (f_dest3.getText().length()>=5) {
        // JOptionPane.showMessageDialog(this, "Alert\nPlz Enter Maximun 4 Characters");
        //}
    }//GEN-LAST:event_f_dest3KeyReleased

    private void jTable2ComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jTable2ComponentResized
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable2ComponentResized

    private void jTable2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MousePressed
        // TODO add your handling code here:

    }//GEN-LAST:event_jTable2MousePressed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:

        boolean e = jTable2.isEditing();
        if (e == false) {
            //    JOptionPane.showMessageDialog(null, "");

        }


    }//GEN-LAST:event_jTable2MouseClicked

    private void f_stdKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_f_stdKeyReleased
        // TODO add your handling code here:

        if (f_std.getText().length() > 5) {
            char f = f_std.getText().charAt(0);
            char s = f_std.getText().charAt(1);
            char t = f_std.getText().charAt(2);
            char fth = f_std.getText().charAt(3);
            char ffth = f_std.getText().charAt(4);
            f_std.setText("" + f + "" + s + "" + t + "" + fth + "" + ffth + "");
            return;
        }

        if ((f_std.getText().length() > 1) && (f_std.getText().length() < 3)) {
            f_std.setText("" + f_std.getText() + ":");

        }
    }//GEN-LAST:event_f_stdKeyReleased

    private void crewComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crewComboActionPerformed
        // TODO add your handling code here:

        //   try {
        //con = Connect.ConnectDB();
        //String c = (String)crewCombo.getSelectedItem();
        //String rg = (String)regCombo.getSelectedItem();
        //String sql = "update [weight Correction] set crew = '"+c+"',REGISTRATION = '"+rg+"' where FLT_NO  = '"+flight1+"'";
        //  pst = con.prepareStatement(sql);
        //  pst.execute();
        // String sql = "update [weight Correction] set DOW = '"+c+"' where FLT_NO  = '"+flight1+"'";
        // setDOW_I();
        //  } catch (SQLException ex) {
        //    Logger.getLogger(FlightInfo.class.getName()).log(Level.SEVERE, null, ex);
        //}
    }//GEN-LAST:event_crewComboActionPerformed

    private void list1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_list1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_list1ActionPerformed

    private void trip_fActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trip_fActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_trip_fActionPerformed

    private void f_dest1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_f_dest1KeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_f_dest1KeyPressed

    private void f_dest1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_f_dest1KeyTyped
        // TODO add your handling code here:

    }//GEN-LAST:event_f_dest1KeyTyped

    private void check5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_check5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_check5ActionPerformed

    private void check7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_check7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_check7ActionPerformed

    private void check8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_check8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_check8ActionPerformed

    private void check9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_check9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_check9ActionPerformed

    private void check11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_check11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_check11ActionPerformed

    private void check12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_check12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_check12ActionPerformed

    private void check13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_check13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_check13ActionPerformed

    private void check14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_check14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_check14ActionPerformed

    private void check16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_check16ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_check16ActionPerformed

    private void check17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_check17ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_check17ActionPerformed

    private void check18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_check18ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_check18ActionPerformed

    private void check20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_check20ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_check20ActionPerformed

    private void check21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_check21ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_check21ActionPerformed

    private void check22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_check22ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_check22ActionPerformed

    private void check23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_check23ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_check23ActionPerformed

    private void check25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_check25ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_check25ActionPerformed

    private void jButton28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton28ActionPerformed
        // TODO add your handling code here:

        try {
            con = Connect.ConnectDB();

            String fix = "";
            if (check1.isSelected()) {

                String sql1 = "select * from newFlight where Active ='yes' and Flt_No = '" + flight1 + "'";
                pst = con.prepareStatement(sql1);
                rs = pst.executeQuery();
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "The flight = '" + flight1 + "' is Loaded. Please Unload the flight then you will delete them", "Error", JOptionPane.ERROR_MESSAGE);

                    return;

                }

                fix = flight1;
                check1.setVisible(false);
            } else if (check2.isSelected()) {

                String sql1 = "select * from newFlight where Active ='yes' and Flt_No = '" + flight2 + "'";
                pst = con.prepareStatement(sql1);
                rs = pst.executeQuery();
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "The flight = '" + flight2 + "' is Loaded. Please Unload the flight then you will delete them", "Error", JOptionPane.ERROR_MESSAGE);

                    return;

                }
                fix = flight2;
                check2.setVisible(false);
            } else if (check3.isSelected()) {

                String sql1 = "select * from newFlight where Active ='yes' and Flt_No = '" + flight3 + "'";
                pst = con.prepareStatement(sql1);
                rs = pst.executeQuery();
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "The flight = '" + flight3 + "' is Loaded. Please Unload the flight then you will delete them", "Error", JOptionPane.ERROR_MESSAGE);

                    return;

                }
                fix = flight3;
                check3.setVisible(false);
            } else if (check4.isSelected()) {

                String sql1 = "select * from newFlight where Active ='yes' and Flt_No = '" + flight4 + "'";
                pst = con.prepareStatement(sql1);
                rs = pst.executeQuery();
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "The flight = '" + flight4 + "' is Loaded. Please Unload the flight then you will delete them", "Error", JOptionPane.ERROR_MESSAGE);

                    return;

                }
                fix = flight4;
                check4.setVisible(false);
            } else if (check5.isSelected()) {

                String sql1 = "select * from newFlight where Active ='yes' and Flt_No = '" + flight5 + "'";
                pst = con.prepareStatement(sql1);
                rs = pst.executeQuery();
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "The flight = '" + flight5 + "' is Loaded. Please Unload the flight then you will delete them", "Error", JOptionPane.ERROR_MESSAGE);

                    return;

                }
                fix = flight5;
                check5.setVisible(false);
            } else if (check6.isSelected()) {

                String sql1 = "select * from newFlight where Active ='yes' and Flt_No = '" + flight6 + "'";
                pst = con.prepareStatement(sql1);
                rs = pst.executeQuery();
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "The flight = '" + flight6 + "' is Loaded. Please Unload the flight then you will delete them", "Error", JOptionPane.ERROR_MESSAGE);

                    return;

                }
                fix = flight6;
                check6.setVisible(false);
            } else if (check7.isSelected()) {

                String sql1 = "select * from newFlight where Active ='yes' and Flt_No = '" + flight7 + "'";
                pst = con.prepareStatement(sql1);
                rs = pst.executeQuery();
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "The flight = '" + flight7 + "' is Loaded. Please Unload the flight then you will delete them", "Error", JOptionPane.ERROR_MESSAGE);

                    return;

                }
                fix = flight7;
                check7.setVisible(false);

            } else if (check8.isSelected()) {

                String sql1 = "select * from newFlight where Active ='yes' and Flt_No = '" + flight8 + "'";
                pst = con.prepareStatement(sql1);
                rs = pst.executeQuery();
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "The flight = '" + flight8 + "' is Loaded. Please Unload the flight then you will delete them", "Error", JOptionPane.ERROR_MESSAGE);

                    return;

                }
                fix = flight8;
                check8.setVisible(false);

            } else if (check9.isSelected()) {

                String sql1 = "select * from newFlight where Active ='yes' and Flt_No = '" + flight9 + "'";
                pst = con.prepareStatement(sql1);
                rs = pst.executeQuery();
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "The flight = '" + flight9 + "' is Loaded. Please Unload the flight then you will delete them", "Error", JOptionPane.ERROR_MESSAGE);

                    return;

                }
                fix = flight9;
                check9.setVisible(false);

            } else if (check10.isSelected()) {

                String sql1 = "select * from newFlight where Active ='yes' and Flt_No = '" + flight10 + "'";
                pst = con.prepareStatement(sql1);
                rs = pst.executeQuery();
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "The flight = '" + flight10 + "' is Loaded. Please Unload the flight then you will delete them", "Error", JOptionPane.ERROR_MESSAGE);

                    return;

                }
                fix = flight10;
                check10.setVisible(false);

            } else if (check11.isSelected()) {

                String sql1 = "select * from newFlight where Active ='yes' and Flt_No = '" + flight11 + "'";
                pst = con.prepareStatement(sql1);
                rs = pst.executeQuery();
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "The flight = '" + flight11 + "' is Loaded. Please Unload the flight then you will delete them", "Error", JOptionPane.ERROR_MESSAGE);

                    return;

                }
                fix = flight11;
                check11.setVisible(false);

            } else if (check12.isSelected()) {

                String sql1 = "select * from newFlight where Active ='yes' and Flt_No = '" + flight12 + "'";
                pst = con.prepareStatement(sql1);
                rs = pst.executeQuery();
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "The flight = '" + flight12 + "' is Loaded. Please Unload the flight then you will delete them", "Error", JOptionPane.ERROR_MESSAGE);

                    return;

                }
                fix = flight12;
                check12.setVisible(false);

            } else if (check13.isSelected()) {

                String sql1 = "select * from newFlight where Active ='yes' and Flt_No = '" + flight13 + "'";
                pst = con.prepareStatement(sql1);
                rs = pst.executeQuery();
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "The flight = '" + flight13 + "' is Loaded. Please Unload the flight then you will delete them", "Error", JOptionPane.ERROR_MESSAGE);

                    return;

                }
                fix = flight13;
                check13.setVisible(false);

            } else if (check14.isSelected()) {

                String sql1 = "select * from newFlight where Active ='yes' and Flt_No = '" + flight14 + "'";
                pst = con.prepareStatement(sql1);
                rs = pst.executeQuery();
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "The flight = '" + flight14 + "' is Loaded. Please Unload the flight then you will delete them", "Error", JOptionPane.ERROR_MESSAGE);

                    return;

                }
                fix = flight14;
                check14.setVisible(false);

            } else if (check15.isSelected()) {

                String sql1 = "select * from newFlight where Active ='yes' and Flt_No = '" + flight15 + "'";
                pst = con.prepareStatement(sql1);
                rs = pst.executeQuery();
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "The flight = '" + flight15 + "' is Loaded. Please Unload the flight then you will delete them", "Error", JOptionPane.ERROR_MESSAGE);

                    return;

                }
                fix = flight15;
                check15.setVisible(false);

            } else if (check16.isSelected()) {

                String sql1 = "select * from newFlight where Active ='yes' and Flt_No = '" + flight16 + "'";
                pst = con.prepareStatement(sql1);
                rs = pst.executeQuery();
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "The flight = '" + flight16 + "' is Loaded. Please Unload the flight then you will delete them", "Error", JOptionPane.ERROR_MESSAGE);
                    return;

                }
                fix = flight16;
                check16.setVisible(false);

            } else if (check17.isSelected()) {

                String sql1 = "select * from newFlight where Active ='yes' and Flt_No = '" + flight17 + "'";
                pst = con.prepareStatement(sql1);
                rs = pst.executeQuery();
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "The flight = '" + flight17 + "' is Loaded. Please Unload the flight then you will delete them", "Error", JOptionPane.ERROR_MESSAGE);

                    return;

                }
                fix = flight17;
                check17.setVisible(false);

            } else if (check18.isSelected()) {

                String sql1 = "select * from newFlight where Active ='yes' and Flt_No = '" + flight18 + "'";
                pst = con.prepareStatement(sql1);
                rs = pst.executeQuery();
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "The flight = '" + flight18 + "' is Loaded. Please Unload the flight then you will delete them", "Error", JOptionPane.ERROR_MESSAGE);

                    return;

                }
                fix = flight18;
                check18.setVisible(false);

            } else if (check19.isSelected()) {

                String sql1 = "select * from newFlight where Active ='yes' and Flt_No = '" + flight19 + "'";
                pst = con.prepareStatement(sql1);
                rs = pst.executeQuery();
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "The flight = '" + flight19 + "' is Loaded. Please Unload the flight then you will delete them", "Error", JOptionPane.ERROR_MESSAGE);

                    return;

                }
                fix = flight19;
                check19.setVisible(false);

            } else if (check20.isSelected()) {

                String sql1 = "select * from newFlight where Active ='yes' and Flt_No = '" + flight20 + "'";
                pst = con.prepareStatement(sql1);
                rs = pst.executeQuery();
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "The flight = '" + flight20 + "' is Loaded. Please Unload the flight then you will delete them", "Error", JOptionPane.ERROR_MESSAGE);

                    return;

                }
                fix = flight20;
                check20.setVisible(false);

            } else if (check21.isSelected()) {

                String sql1 = "select * from newFlight where Active ='yes' and Flt_No = '" + flight21 + "'";
                pst = con.prepareStatement(sql1);
                rs = pst.executeQuery();
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "The flight = '" + flight21 + "' is Loaded. Please Unload the flight then you will delete them", "Error", JOptionPane.ERROR_MESSAGE);

                    return;

                }
                fix = flight21;
                check21.setVisible(false);

            } else if (check22.isSelected()) {

                String sql1 = "select * from newFlight where Active ='yes' and Flt_No = '" + flight22 + "'";
                pst = con.prepareStatement(sql1);
                rs = pst.executeQuery();
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "The flight = '" + flight22 + "' is Loaded. Please Unload the flight then you will delete them", "Error", JOptionPane.ERROR_MESSAGE);

                    return;

                }
                fix = flight22;
                check22.setVisible(false);

            } else if (check23.isSelected()) {

                String sql1 = "select * from newFlight where Active ='yes' and Flt_No = '" + flight23 + "'";
                pst = con.prepareStatement(sql1);
                rs = pst.executeQuery();
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "The flight = '" + flight23 + "' is Loaded. Please Unload the flight then you will delete them", "Error", JOptionPane.ERROR_MESSAGE);

                    return;

                }
                fix = flight23;
                check23.setVisible(false);

            } else if (check24.isSelected()) {

                String sql1 = "select * from newFlight where Active ='yes' and Flt_No = '" + flight24 + "'";
                pst = con.prepareStatement(sql1);
                rs = pst.executeQuery();
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "The flight = '" + flight24 + "' is Loaded. Please Unload the flight then you will delete them", "Error", JOptionPane.ERROR_MESSAGE);

                    return;

                }
                fix = flight24;
                check24.setVisible(false);

            } else if (check25.isSelected()) {

                String sql1 = "select * from newFlight where Active ='yes' and Flt_No = '" + flight25 + "'";
                pst = con.prepareStatement(sql1);
                rs = pst.executeQuery();
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "The flight = '" + flight25 + "' is Loaded. Please Unload the flight then you will delete them", "Error", JOptionPane.ERROR_MESSAGE);

                    return;

                }
                fix = flight25;
                check25.setVisible(false);

            }
            cycle();

            int des = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this Flight?", "Delete", JOptionPane.YES_NO_OPTION);
            if (des == 0) {
                checkList = 0;
                String sql = "delete from newFlight where FLT_NO='" + fix + "'and Active ='no'";
                pst = con.prepareStatement(sql);
                pst.execute();
                cycle();
            }

        } catch (SQLException ex) {
            Logger.getLogger(FlightInfo.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton28ActionPerformed

    private void list5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_list5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_list5ActionPerformed

    private void list9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_list9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_list9ActionPerformed

    private void list13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_list13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_list13ActionPerformed

    private void list17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_list17ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_list17ActionPerformed

    private void list21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_list21ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_list21ActionPerformed

    private void list8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_list8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_list8ActionPerformed

    private void crewComboMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_crewComboMouseReleased
        // TODO add your handling code here:

    }//GEN-LAST:event_crewComboMouseReleased

    private void crewComboMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_crewComboMousePressed
        // TODO add your handling code here:

    }//GEN-LAST:event_crewComboMousePressed

    private void crewComboMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_crewComboMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_crewComboMouseClicked

    private void regComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regComboActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_regComboActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        cycle();
    }//GEN-LAST:event_jButton9ActionPerformed

    private void timeClockMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_timeClockMouseClicked
        // TODO add your handling code here:
        jPanel4.setVisible(true);
    }//GEN-LAST:event_timeClockMouseClicked

    private void hour24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hour24ActionPerformed
        // TODO add your handling code here:
        jPanel4.setVisible(false);
    }//GEN-LAST:event_hour24ActionPerformed

    private void hour12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hour12ActionPerformed
        // TODO add your handling code here:
        jPanel4.setVisible(false);
    }//GEN-LAST:event_hour12ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton19ActionPerformed

    private void deadload1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_deadload1KeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_deadload1KeyPressed

    private void deadload1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_deadload1KeyReleased
        // TODO add your handling code here:
        int r = deadload1.getSelectedRow();
        String temp = deadload1.getValueAt(r, 0).toString();
        String netWeight = deadload1.getValueAt(r, 2).toString();
        int net = Integer.parseInt(netWeight);
        //String gross = deadload1.getValueAt(r, 1).toString();
        int gross1 = 0;

        String uld = null;
        if (temp.length() >= 3) {
            uld = "" + temp.charAt(0) + "" + temp.charAt(1) + "" + temp.charAt(2) + "";
        } else {
            deadload1.setValueAt("0", r, 3);

            deadload1.setValueAt("0", r, 1);
            return;
        }

        int count = 0;

        try {
            con = Connect.ConnectDB();
            String sql = "SELECT * FROM ULD where ULDS = '" + uld + "' ";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
//            String c = (String) density_combo.getSelectedItem();
//            float o = Float.parseFloat(c);
            while (rs.next()) {
                int t = (int) rs.getFloat("Tare Weight");
                int h = (int) rs.getFloat("Height inch");
                String hi = Integer.toString(h);
                String i = Integer.toString(t);
                deadload1.setValueAt(hi, r, 4);

                deadload1.setValueAt(i, r, 3);

                deadload1.setValueAt(i, r, 1);
                gross1 = t;
                count++;
            }
            //if count =0 which means ULS is not present in database 
            if (count == 0) {
                int choise = JOptionPane.showConfirmDialog(null, "This is not a valid uld.\n Do you want to save it?", "Warrning", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                if (choise == 0) {

                    deadload1.setValueAt("0", r, 3);

                    deadload1.setValueAt("0", r, 1);
                }
                if (choise == 1) {
                    deadload1.setValueAt(null, r, 0);
                }
            }

            int total1 = gross1 + net;
            deadload1.setValueAt("" + total1 + "", r, 1);

        } catch (SQLException ex) {
            Logger.getLogger(FlightInfo.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_deadload1KeyReleased

    private void deadload1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_deadload1KeyTyped
        // TODO add your handling code here:

    }//GEN-LAST:event_deadload1KeyTyped

    private void applyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_applyActionPerformed
        // TODO add your handling code here:

        int check = 0;
        int i;
        for (i = countRow - 1; i >= 0; i--) {
            String uld = (String) deadload1.getValueAt(i, 0);
            int gross = Integer.parseInt(deadload1.getValueAt(i, 1).toString());
            int weight = Integer.parseInt(deadload1.getValueAt(i, 2).toString());
            int tare = Integer.parseInt(deadload1.getValueAt(i, 3).toString());
            int height = Integer.parseInt(deadload1.getValueAt(i, 4).toString());
            String dest = (String) deadload1.getValueAt(i, 5);
            String commodity = (String) deadload1.getValueAt(i, 6);
            String location = (String) deadload1.getValueAt(i, 7);
            String dgsl = (String) deadload1.getValueAt(i, 8);
            String overhang = deadload1.getValueAt(i, 9).toString();
            String sxs = deadload1.getValueAt(i, 10).toString();
            String onward = (String) deadload1.getValueAt(i, 11);
            String description = (String) deadload1.getValueAt(i, 12);

            String sql = "insert into Deadload values('" + flight1 + "','" + uld + "','" + gross + "','" + height + "','" + weight + "','" + tare + "','" + dest + "','" + commodity + "','" + location + "','" + dgsl + "','" + overhang + "','" + sxs + "','" + description + "','ok','" + onward + "')";

            try {
                con = Connect.ConnectDB();
                pst = con.prepareStatement(sql);
                pst.execute();

            } catch (SQLException ex) {
                Logger.getLogger(FlightInfo.class.getName()).log(Level.SEVERE, null, ex);
            }
            check++;
        }
        if (check > 0) {
            countRow = 0;
        }

        deadload_update();
        deadload_update_distribution();
    }//GEN-LAST:event_applyActionPerformed

    private void f_flight_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_f_flight_noActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_f_flight_noActionPerformed

    private void f_flight_noKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_f_flight_noKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_f_flight_noKeyReleased

    private void deadload2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deadload2MouseReleased
        MD1(0);
        MD2(0);
        MD3(0);
        MD4(0);
        MD20(0);
        MD16(0);

        checkboxMD1.setSelected(true);
        checkboxMD2.setSelected(true);
        checkboxMD3.setSelected(true);
        checkboxMD16.setSelected(true);
        checkboxMD20.setSelected(true);
        checkBoxMD1();
        checkBoxMD2();
        checkBoxMD3();
        checkBoxMD16();
        checkBoxMD20();

        switchPanels1(jScrollPane9);
    }//GEN-LAST:event_deadload2MouseReleased

    private void jLabel8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseEntered
        // TODO add your handling code here:
        if (jLabel8.getText() == "N") {
            if (clicked == 1) {

                // DefaultTableModel DFT = (DefaultTableModel) deadload2.getModel();
                int d = deadload2.getSelectedRow();

                jLabel8.setText(deadload2.getValueAt(d, 0).toString());
                DefaultTableModel model = (DefaultTableModel) deadload2.getModel();

                //Delete Selected Row        
                //Check if their is a row selected
                model.removeRow(d);

            }
        }

        clicked = 0;
    }//GEN-LAST:event_jLabel8MouseEntered

    private void deadload2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deadload2MouseClicked
        // TODO add your handling code here:

        clicked = 0;
    }//GEN-LAST:event_deadload2MouseClicked

    private void jPanel1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseReleased
        // TODO add your handling code here:


    }//GEN-LAST:event_jPanel1MouseReleased

    private void deadload2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deadload2MouseExited
        // TODO add your handling code here:

        MD1(0);
        MD2(0);
        MD3(0);
        MD4(0);
        MD20(0);
        MD16(0);

        clicked = 1;

        checkboxMD1.setSelected(true);
        checkboxMD2.setSelected(true);
        checkboxMD3.setSelected(true);
        checkboxMD16.setSelected(true);
        checkboxMD20.setSelected(true);
        checkBoxMD1();
        checkBoxMD2();
        checkBoxMD3();
        checkBoxMD16();
        checkBoxMD20();
        switchPanels1(jScrollPane9);
    }//GEN-LAST:event_deadload2MouseExited

    private void jLabel9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseEntered
        // TODO add your handling code here:
        if (jLabel9.getText() == "N") {
            if (clicked == 1) {

                // DefaultTableModel DFT = (DefaultTableModel) deadload2.getModel();
                int d = deadload2.getSelectedRow();

                jLabel9.setText(deadload2.getValueAt(d, 0).toString());
                DefaultTableModel model = (DefaultTableModel) deadload2.getModel();

                //Delete Selected Row        
                //Check if their is a row selected
                model.removeRow(d);

            }
        }
    }//GEN-LAST:event_jLabel9MouseEntered

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_jLabel8MouseClicked

    private void jLabel8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseExited
        // TODO add your handling code here:

    }//GEN-LAST:event_jLabel8MouseExited

    private void jLabel10MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseEntered
        // TODO add your handling code here:
        if (jLabel10.getText() == "N") {
            if (clicked == 1) {

                // DefaultTableModel DFT = (DefaultTableModel) deadload2.getModel();
                jLabel10.setText(jLabel8.getText());

                jLabel8.setText("N");
            }
        }

    }//GEN-LAST:event_jLabel10MouseEntered

    private void jLabel8MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseReleased
        // TODO add your handling code here:
        jLabel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 1));        // TODO add your handling code here:
        clicked = 1;
    }//GEN-LAST:event_jLabel8MouseReleased

    private void deadload2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deadload2MousePressed
        dragApply();

        int row = deadload2.getSelectedRow();
        String s = (String) deadload2.getValueAt(row, 1);
        String uldType = "" + s.charAt(0) + "" + s.charAt(1) + "" + s.charAt(2) + "";
        String sql = " SELECT  * FROM ULD where ULDS = '" + uldType + "'";
        try {
            con = Connect.ConnectDB();
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {

                String md1 = rs.getString("MD1");
                String md2 = rs.getString("MD2");
                String md3 = rs.getString("MD3");
                String md4 = rs.getString("MD4");
                String md41 = rs.getString("MD41");
                String md16 = rs.getString("MD16");
                String md20 = rs.getString("MD20");
                if (!(md1 == null && md2 == null && md3 == null && md4 == null && md16 == null && md20 == null)) {

                    if (md1 == null) {
                        checkboxMD1.setSelected(false);
                        checkBoxMD1();

                    }
                    if (md2 == null) {
                        checkboxMD2.setSelected(false);
                        checkBoxMD2();
                    }
                    if (md3 == null) {
                        checkboxMD3.setSelected(false);
                        checkBoxMD3();
                    }
                    if (md16 == null) {
                        checkboxMD16.setSelected(false);
                        checkBoxMD16();
                    }
                    if (md20 == null) {
                        checkboxMD20.setSelected(false);
                        checkBoxMD20();
                    }
                }
                if (Objects.equals(md1, "OK")) {
                    MD1(3);
                    switchPanels1(jScrollPane9);
                }

                if (Objects.equals(md2, "OK")) {
                    MD2(3);
                    switchPanels1(jScrollPane9);
                }
                if (Objects.equals(md3, "OK")) {
                    MD3(3);
                    switchPanels1(jScrollPane9);
                }
                if (Objects.equals(md4, "OK")) {
                    MD4(3);
                    switchPanels1(jScrollPane9);
                }
                if (Objects.equals(md16, "OK")) {
                    MD16(3);
                    switchPanels1(jScrollPane9);
                }
                if (Objects.equals(md20, "OK")) {
                    MD20(3);
                    switchPanels1(jScrollPane9);
                }

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }


    }//GEN-LAST:event_deadload2MousePressed

    private void jLabel8MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MousePressed
        // TODO add your handling code here:
        jLabel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));        // TODO add your handling code here:

    }//GEN-LAST:event_jLabel8MousePressed

    private void f_createMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_f_createMouseReleased
        // TODO add your handling code here:

    }//GEN-LAST:event_f_createMouseReleased


    private void f_flight_noMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_f_flight_noMouseEntered
        // TODO add your handling code here:


    }//GEN-LAST:event_f_flight_noMouseEntered

    private void f_flight_noMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_f_flight_noMouseClicked
        // TODO add your handling code here:
        f_flight_no.setBackground(new Color(204, 204, 204));
    }//GEN-LAST:event_f_flight_noMouseClicked

    private void jTable2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseExited
        // TODO add your handling code here:

    }//GEN-LAST:event_jTable2MouseExited

    private void jTable2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseReleased
        // TODO add your handling code here:

    }//GEN-LAST:event_jTable2MouseReleased

    private void jTable2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseEntered
        // TODO add your handling code here:

    }//GEN-LAST:event_jTable2MouseEntered

    private void f_orgMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_f_orgMouseClicked
        // TODO add your handling code here:
        f_org.setBackground(new Color(204, 204, 204));

    }//GEN-LAST:event_f_orgMouseClicked

    private void f_dest1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_f_dest1MouseClicked
        // TODO add your handling code here:

        f_dest1.setBackground(new Color(204, 204, 204));

    }//GEN-LAST:event_f_dest1MouseClicked

    private void f_stdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_f_stdMouseClicked
        // TODO add your handling code here:
        f_std.setBackground(new Color(204, 204, 204));

    }//GEN-LAST:event_f_stdMouseClicked

    private void deadload2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deadload2MouseEntered
        // TODO add your handling code here:


    }//GEN-LAST:event_deadload2MouseEntered

    private void FJGMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FJGMouseExited
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        pressExitDrag(lbel, "abc");

    }//GEN-LAST:event_FJGMouseExited

    private void ABMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ABMouseEntered
        // TODO add your handling code here:

        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();

        char findSymbol = lbel.getText().charAt(0);

        if (findSymbol != '<') {
            lbel.setText("N");
        }
        if (lbel.getText().equals("N")) {

            random(lbel);
        }
        deadload2.getSelectionModel().clearSelection();

    }//GEN-LAST:event_ABMouseEntered

    private void BCMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BCMouseEntered
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        char findSymbol = lbel.getText().charAt(0);

        if (findSymbol != '<') {
            lbel.setText("N");
        }
        if (lbel.getText().equals("N")) {

            random(lbel);
        }
        deadload2.getSelectionModel().clearSelection();
    }//GEN-LAST:event_BCMouseEntered

    private void ABMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ABMousePressed
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        pressExitDrag(lbel, "text");

    }//GEN-LAST:event_ABMousePressed

    private void ABMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ABMouseExited
        // TODO add your handling code here:

        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        pressExitDrag(lbel, "abc");

    }//GEN-LAST:event_ABMouseExited

    private void BCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BCMouseClicked
        // TODO add your handling code here:


    }//GEN-LAST:event_BCMouseClicked

    private void CEMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CEMouseEntered
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        char findSymbol = lbel.getText().charAt(0);

        if (findSymbol != '<') {
            lbel.setText("N");
        }
        if (lbel.getText().equals("N")) {

            random(lbel);
        }
        deadload2.getSelectionModel().clearSelection();
    }//GEN-LAST:event_CEMouseEntered

    private void ABMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ABMouseReleased
        // TODO add your handling code here:


    }//GEN-LAST:event_ABMouseReleased

    private void list1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_list1MouseExited
        // TODO add your handling code here:


    }//GEN-LAST:event_list1MouseExited

    private void JLGMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JLGMouseExited
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        pressExitDrag(lbel, "abc");
    }//GEN-LAST:event_JLGMouseExited

    private void distributionPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_distributionPanelMouseEntered
        // TODO add your handling code here:
        deadload2.getSelectionModel().clearSelection();

    }//GEN-LAST:event_distributionPanelMouseEntered

    private void JLGMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JLGMouseEntered
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        char findSymbol = lbel.getText().charAt(0);

        if (findSymbol != '<') {
            lbel.setText("N");
        }
        if (lbel.getText().equals("N")) {

            random(lbel);
        }
        deadload2.getSelectionModel().clearSelection();
    }//GEN-LAST:event_JLGMouseEntered

    private void RMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RMouseEntered
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        char findSymbol = lbel.getText().charAt(0);

        if (findSymbol != '<') {
            lbel.setText("N");
        }
        if (lbel.getText().equals("N")) {

            random(lbel);
        }
        deadload2.getSelectionModel().clearSelection();

    }//GEN-LAST:event_RMouseEntered

    private void SMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SMouseEntered
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        char findSymbol = lbel.getText().charAt(0);

        if (findSymbol != '<') {
            lbel.setText("N");
        }
        if (lbel.getText().equals("N")) {

            random(lbel);
        }
        deadload2.getSelectionModel().clearSelection();


    }//GEN-LAST:event_SMouseEntered

    private void TMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TMouseEntered
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        char findSymbol = lbel.getText().charAt(0);

        if (findSymbol != '<') {
            lbel.setText("N");
        }
        if (lbel.getText().equals("N")) {

            random(lbel);
        }
        deadload2.getSelectionModel().clearSelection();

    }//GEN-LAST:event_TMouseEntered

    private void UMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UMouseEntered
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        char findSymbol = lbel.getText().charAt(0);

        if (findSymbol != '<') {
            lbel.setText("N");
        }
        if (lbel.getText().equals("N")) {

            random(lbel);
        }
        deadload2.getSelectionModel().clearSelection();


    }//GEN-LAST:event_UMouseEntered

    private void EFMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EFMouseEntered
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        char findSymbol = lbel.getText().charAt(0);

        if (findSymbol != '<') {
            lbel.setText("N");
        }
        if (lbel.getText().equals("N")) {

            random(lbel);
        }
        deadload2.getSelectionModel().clearSelection();
    }//GEN-LAST:event_EFMouseEntered

    private void FHMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FHMouseEntered
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        char findSymbol = lbel.getText().charAt(0);

        if (findSymbol != '<') {
            lbel.setText("N");
        }
        if (lbel.getText().equals("N")) {

            random(lbel);
        }
        deadload2.getSelectionModel().clearSelection();

    }//GEN-LAST:event_FHMouseEntered

    private void HJMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HJMouseEntered
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        char findSymbol = lbel.getText().charAt(0);

        if (findSymbol != '<') {
            lbel.setText("N");
        }
        if (lbel.getText().equals("N")) {

            random(lbel);
        }
        deadload2.getSelectionModel().clearSelection();

    }//GEN-LAST:event_HJMouseEntered

    private void JKMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JKMouseEntered
        // TODO add your handling code here:

        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        char findSymbol = lbel.getText().charAt(0);

        if (findSymbol != '<') {
            lbel.setText("N");
        }
        if (lbel.getText().equals("N")) {

            random(lbel);
        }
        deadload2.getSelectionModel().clearSelection();
    }//GEN-LAST:event_JKMouseEntered

    private void KMMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_KMMouseEntered
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        char findSymbol = lbel.getText().charAt(0);

        if (findSymbol != '<') {
            lbel.setText("N");
        }
        if (lbel.getText().equals("N")) {

            random(lbel);
        }
        deadload2.getSelectionModel().clearSelection();

    }//GEN-LAST:event_KMMouseEntered

    private void MPMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MPMouseEntered
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        char findSymbol = lbel.getText().charAt(0);

        if (findSymbol != '<') {
            lbel.setText("N");
        }
        if (lbel.getText().equals("N")) {

            random(lbel);
        }
        deadload2.getSelectionModel().clearSelection();

    }//GEN-LAST:event_MPMouseEntered

    private void LPRMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LPRMouseEntered
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        char findSymbol = lbel.getText().charAt(0);

        if (findSymbol != '<') {
            lbel.setText("N");
        }
        if (lbel.getText().equals("N")) {

            random(lbel);
        }
        deadload2.getSelectionModel().clearSelection();
    }//GEN-LAST:event_LPRMouseEntered

    private void JLRMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JLRMouseEntered
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        char findSymbol = lbel.getText().charAt(0);

        if (findSymbol != '<') {
            lbel.setText("N");
        }
        if (lbel.getText().equals("N")) {

            random(lbel);
        }
        deadload2.getSelectionModel().clearSelection();
    }//GEN-LAST:event_JLRMouseEntered

    private void FJRMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FJRMouseEntered
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        char findSymbol = lbel.getText().charAt(0);

        if (findSymbol != '<') {
            lbel.setText("N");
        }
        if (lbel.getText().equals("N")) {

            random(lbel);
        }
        deadload2.getSelectionModel().clearSelection();
    }//GEN-LAST:event_FJRMouseEntered

    private void CFRMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CFRMouseEntered
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        char findSymbol = lbel.getText().charAt(0);

        if (findSymbol != '<') {
            lbel.setText("N");
        }
        if (lbel.getText().equals("N")) {

            random(lbel);
        }
        deadload2.getSelectionModel().clearSelection();
    }//GEN-LAST:event_CFRMouseEntered

    private void AMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AMouseEntered
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        char findSymbol = lbel.getText().charAt(0);

        if (findSymbol != '<') {
            lbel.setText("N");
        }
        if (lbel.getText().equals("N")) {

            random(lbel);
        }
        deadload2.getSelectionModel().clearSelection();
    }//GEN-LAST:event_AMouseEntered

    private void BMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BMouseEntered
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        char findSymbol = lbel.getText().charAt(0);

        if (findSymbol != '<') {
            lbel.setText("N");
        }
        if (lbel.getText().equals("N")) {

            random(lbel);
        }
        deadload2.getSelectionModel().clearSelection();
    }//GEN-LAST:event_BMouseEntered

    private void CMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CMouseEntered
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        char findSymbol = lbel.getText().charAt(0);

        if (findSymbol != '<') {
            lbel.setText("N");
        }
        if (lbel.getText().equals("N")) {

            random(lbel);
        }
        deadload2.getSelectionModel().clearSelection();

    }//GEN-LAST:event_CMouseEntered

    private void DMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DMouseEntered
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        char findSymbol = lbel.getText().charAt(0);

        if (findSymbol != '<') {
            lbel.setText("N");
        }
        if (lbel.getText().equals("N")) {

            random(lbel);
        }
        deadload2.getSelectionModel().clearSelection();

    }//GEN-LAST:event_DMouseEntered

    private void EMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EMouseEntered
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        char findSymbol = lbel.getText().charAt(0);

        if (findSymbol != '<') {
            lbel.setText("N");
        }
        if (lbel.getText().equals("N")) {

            random(lbel);
        }
        deadload2.getSelectionModel().clearSelection();

    }//GEN-LAST:event_EMouseEntered

    private void FMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FMouseEntered
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        char findSymbol = lbel.getText().charAt(0);

        if (findSymbol != '<') {
            lbel.setText("N");
        }
        if (lbel.getText().equals("N")) {

            random(lbel);
        }
        deadload2.getSelectionModel().clearSelection();

    }//GEN-LAST:event_FMouseEntered

    private void GMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GMouseEntered
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        char findSymbol = lbel.getText().charAt(0);

        if (findSymbol != '<') {
            lbel.setText("N");
        }
        if (lbel.getText().equals("N")) {

            random(lbel);
        }
        deadload2.getSelectionModel().clearSelection();

    }//GEN-LAST:event_GMouseEntered

    private void HMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HMouseEntered
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        char findSymbol = lbel.getText().charAt(0);

        if (findSymbol != '<') {
            lbel.setText("N");
        }
        if (lbel.getText().equals("N")) {

            random(lbel);
        }
        deadload2.getSelectionModel().clearSelection();

    }//GEN-LAST:event_HMouseEntered

    private void JMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JMouseEntered
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        char findSymbol = lbel.getText().charAt(0);

        if (findSymbol != '<') {
            lbel.setText("N");
        }
        if (lbel.getText().equals("N")) {

            random(lbel);
        }
        deadload2.getSelectionModel().clearSelection();

    }//GEN-LAST:event_JMouseEntered

    private void KMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_KMouseEntered
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        char findSymbol = lbel.getText().charAt(0);

        if (findSymbol != '<') {
            lbel.setText("N");
        }
        if (lbel.getText().equals("N")) {

            random(lbel);
        }
        deadload2.getSelectionModel().clearSelection();

    }//GEN-LAST:event_KMouseEntered

    private void LMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LMouseEntered
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        char findSymbol = lbel.getText().charAt(0);

        if (findSymbol != '<') {
            lbel.setText("N");
        }
        if (lbel.getText().equals("N")) {

            random(lbel);
        }
        deadload2.getSelectionModel().clearSelection();

    }//GEN-LAST:event_LMouseEntered

    private void MMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MMouseEntered
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        char findSymbol = lbel.getText().charAt(0);

        if (findSymbol != '<') {
            lbel.setText("N");
        }
        if (lbel.getText().equals("N")) {

            random(lbel);
        }
        deadload2.getSelectionModel().clearSelection();

    }//GEN-LAST:event_MMouseEntered

    private void PMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PMouseEntered
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        char findSymbol = lbel.getText().charAt(0);

        if (findSymbol != '<') {
            lbel.setText("N");
        }
        if (lbel.getText().equals("N")) {

            random(lbel);
        }
        deadload2.getSelectionModel().clearSelection();

    }//GEN-LAST:event_PMouseEntered

    private void AAMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AAMouseEntered
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        char findSymbol = lbel.getText().charAt(0);

        if (findSymbol != '<') {
            lbel.setText("N");
        }
        if (lbel.getText().equals("N")) {

            random(lbel);
        }
        deadload2.getSelectionModel().clearSelection();

    }//GEN-LAST:event_AAMouseEntered

    private void BBMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BBMouseEntered
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        char findSymbol = lbel.getText().charAt(0);

        if (findSymbol != '<') {
            lbel.setText("N");
        }
        if (lbel.getText().equals("N")) {

            random(lbel);
        }
        deadload2.getSelectionModel().clearSelection();

    }//GEN-LAST:event_BBMouseEntered

    private void CCMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CCMouseEntered
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        char findSymbol = lbel.getText().charAt(0);

        if (findSymbol != '<') {
            lbel.setText("N");
        }
        if (lbel.getText().equals("N")) {

            random(lbel);
        }
        deadload2.getSelectionModel().clearSelection();

    }//GEN-LAST:event_CCMouseEntered

    private void DDMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DDMouseEntered
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        char findSymbol = lbel.getText().charAt(0);

        if (findSymbol != '<') {
            lbel.setText("N");
        }
        if (lbel.getText().equals("N")) {

            random(lbel);
        }
        deadload2.getSelectionModel().clearSelection();

    }//GEN-LAST:event_DDMouseEntered

    private void EEMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EEMouseEntered
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        char findSymbol = lbel.getText().charAt(0);

        if (findSymbol != '<') {
            lbel.setText("N");
        }
        if (lbel.getText().equals("N")) {

            random(lbel);
        }
        deadload2.getSelectionModel().clearSelection();

    }//GEN-LAST:event_EEMouseEntered

    private void FFMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FFMouseEntered
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        char findSymbol = lbel.getText().charAt(0);

        if (findSymbol != '<') {
            lbel.setText("N");
        }
        if (lbel.getText().equals("N")) {

            random(lbel);
        }
        deadload2.getSelectionModel().clearSelection();

    }//GEN-LAST:event_FFMouseEntered

    private void GGMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GGMouseEntered
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        char findSymbol = lbel.getText().charAt(0);

        if (findSymbol != '<') {
            lbel.setText("N");
        }
        if (lbel.getText().equals("N")) {

            random(lbel);
        }
        deadload2.getSelectionModel().clearSelection();

    }//GEN-LAST:event_GGMouseEntered

    private void HHMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HHMouseEntered
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        char findSymbol = lbel.getText().charAt(0);

        if (findSymbol != '<') {
            lbel.setText("N");
        }
        if (lbel.getText().equals("N")) {

            random(lbel);
        }
        deadload2.getSelectionModel().clearSelection();

    }//GEN-LAST:event_HHMouseEntered

    private void JJMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JJMouseEntered
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        char findSymbol = lbel.getText().charAt(0);

        if (findSymbol != '<') {
            lbel.setText("N");
        }
        if (lbel.getText().equals("N")) {

            random(lbel);
        }
        deadload2.getSelectionModel().clearSelection();

    }//GEN-LAST:event_JJMouseEntered

    private void KKMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_KKMouseEntered
        // TODO add your handling code here:

        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        char findSymbol = lbel.getText().charAt(0);

        if (findSymbol != '<') {
            lbel.setText("N");
        }
        if (lbel.getText().equals("N")) {

            random(lbel);
        }
        deadload2.getSelectionModel().clearSelection();

    }//GEN-LAST:event_KKMouseEntered

    private void LLMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LLMouseEntered
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        char findSymbol = lbel.getText().charAt(0);

        if (findSymbol != '<') {
            lbel.setText("N");
        }
        if (lbel.getText().equals("N")) {

            random(lbel);
        }
        deadload2.getSelectionModel().clearSelection();

    }//GEN-LAST:event_LLMouseEntered

    private void MMMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MMMouseEntered
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        char findSymbol = lbel.getText().charAt(0);

        if (findSymbol != '<') {
            lbel.setText("N");
        }
        if (lbel.getText().equals("N")) {

            random(lbel);
        }
        deadload2.getSelectionModel().clearSelection();

    }//GEN-LAST:event_MMMouseEntered

    private void PPMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PPMouseEntered
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        char findSymbol = lbel.getText().charAt(0);

        if (findSymbol != '<') {
            lbel.setText("N");
        }
        if (lbel.getText().equals("N")) {

            random(lbel);
        }
        deadload2.getSelectionModel().clearSelection();

    }//GEN-LAST:event_PPMouseEntered

    private void RRMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RRMouseEntered
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        char findSymbol = lbel.getText().charAt(0);

        if (findSymbol != '<') {
            lbel.setText("N");
        }
        if (lbel.getText().equals("N")) {

            random(lbel);
        }
        deadload2.getSelectionModel().clearSelection();

    }//GEN-LAST:event_RRMouseEntered

    private void SSMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SSMouseEntered
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        char findSymbol = lbel.getText().charAt(0);

        if (findSymbol != '<') {
            lbel.setText("N");
        }
        if (lbel.getText().equals("N")) {

            random(lbel);
        }
        deadload2.getSelectionModel().clearSelection();

    }//GEN-LAST:event_SSMouseEntered

    private void TTMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TTMouseEntered
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        char findSymbol = lbel.getText().charAt(0);

        if (findSymbol != '<') {
            lbel.setText("N");
        }
        if (lbel.getText().equals("N")) {

            random(lbel);
        }
        deadload2.getSelectionModel().clearSelection();

    }//GEN-LAST:event_TTMouseEntered

    private void ABRMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ABRMouseEntered
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        char findSymbol = lbel.getText().charAt(0);

        if (findSymbol != '<') {
            lbel.setText("N");
        }
        if (lbel.getText().equals("N")) {

            random(lbel);
        }
        deadload2.getSelectionModel().clearSelection();

    }//GEN-LAST:event_ABRMouseEntered

    private void ABLMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ABLMouseEntered
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        char findSymbol = lbel.getText().charAt(0);

        if (findSymbol != '<') {
            lbel.setText("N");
        }
        if (lbel.getText().equals("N")) {

            random(lbel);
        }
        deadload2.getSelectionModel().clearSelection();

    }//GEN-LAST:event_ABLMouseEntered

    private void BCRMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BCRMouseEntered
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        char findSymbol = lbel.getText().charAt(0);

        if (findSymbol != '<') {
            lbel.setText("N");
        }
        if (lbel.getText().equals("N")) {

            random(lbel);
        }
        deadload2.getSelectionModel().clearSelection();

    }//GEN-LAST:event_BCRMouseEntered

    private void BCLMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BCLMouseEntered
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        char findSymbol = lbel.getText().charAt(0);

        if (findSymbol != '<') {
            lbel.setText("N");
        }
        if (lbel.getText().equals("N")) {

            random(lbel);
        }
        deadload2.getSelectionModel().clearSelection();

    }//GEN-LAST:event_BCLMouseEntered

    private void CERMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CERMouseEntered
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        char findSymbol = lbel.getText().charAt(0);

        if (findSymbol != '<') {
            lbel.setText("N");
        }
        if (lbel.getText().equals("N")) {

            random(lbel);
        }
        deadload2.getSelectionModel().clearSelection();

    }//GEN-LAST:event_CERMouseEntered

    private void CELMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CELMouseEntered
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        char findSymbol = lbel.getText().charAt(0);

        if (findSymbol != '<') {
            lbel.setText("N");
        }
        if (lbel.getText().equals("N")) {

            random(lbel);
        }
        deadload2.getSelectionModel().clearSelection();

    }//GEN-LAST:event_CELMouseEntered

    private void HJLMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HJLMouseEntered
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        char findSymbol = lbel.getText().charAt(0);

        if (findSymbol != '<') {
            lbel.setText("N");
        }
        if (lbel.getText().equals("N")) {

            random(lbel);
        }
        deadload2.getSelectionModel().clearSelection();

    }//GEN-LAST:event_HJLMouseEntered

    private void FHLMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FHLMouseEntered
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        char findSymbol = lbel.getText().charAt(0);

        if (findSymbol != '<') {
            lbel.setText("N");
        }
        if (lbel.getText().equals("N")) {

            random(lbel);
        }
        deadload2.getSelectionModel().clearSelection();

    }//GEN-LAST:event_FHLMouseEntered

    private void EFLMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EFLMouseEntered
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        char findSymbol = lbel.getText().charAt(0);

        if (findSymbol != '<') {
            lbel.setText("N");
        }
        if (lbel.getText().equals("N")) {

            random(lbel);
        }
        deadload2.getSelectionModel().clearSelection();

    }//GEN-LAST:event_EFLMouseEntered

    private void EFRMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EFRMouseEntered
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        char findSymbol = lbel.getText().charAt(0);

        if (findSymbol != '<') {
            lbel.setText("N");
        }
        if (lbel.getText().equals("N")) {

            random(lbel);
        }
        deadload2.getSelectionModel().clearSelection();

    }//GEN-LAST:event_EFRMouseEntered

    private void FHRMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FHRMouseEntered
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        char findSymbol = lbel.getText().charAt(0);

        if (findSymbol != '<') {
            lbel.setText("N");
        }
        if (lbel.getText().equals("N")) {

            random(lbel);
        }
        deadload2.getSelectionModel().clearSelection();

    }//GEN-LAST:event_FHRMouseEntered

    private void HJRMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HJRMouseEntered
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        char findSymbol = lbel.getText().charAt(0);

        if (findSymbol != '<') {
            lbel.setText("N");
        }
        if (lbel.getText().equals("N")) {

            random(lbel);
        }
        deadload2.getSelectionModel().clearSelection();

    }//GEN-LAST:event_HJRMouseEntered

    private void MPLMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MPLMouseEntered
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        char findSymbol = lbel.getText().charAt(0);

        if (findSymbol != '<') {
            lbel.setText("N");
        }
        if (lbel.getText().equals("N")) {

            random(lbel);
        }
        deadload2.getSelectionModel().clearSelection();

    }//GEN-LAST:event_MPLMouseEntered

    private void KMLMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_KMLMouseEntered
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        char findSymbol = lbel.getText().charAt(0);

        if (findSymbol != '<') {
            lbel.setText("N");
        }
        if (lbel.getText().equals("N")) {

            random(lbel);
        }
        deadload2.getSelectionModel().clearSelection();

    }//GEN-LAST:event_KMLMouseEntered

    private void JKLMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JKLMouseEntered
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        char findSymbol = lbel.getText().charAt(0);

        if (findSymbol != '<') {
            lbel.setText("N");
        }
        if (lbel.getText().equals("N")) {

            random(lbel);
        }
        deadload2.getSelectionModel().clearSelection();

    }//GEN-LAST:event_JKLMouseEntered

    private void JKRMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JKRMouseEntered
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        char findSymbol = lbel.getText().charAt(0);

        if (findSymbol != '<') {
            lbel.setText("N");
        }
        if (lbel.getText().equals("N")) {

            random(lbel);
        }
        deadload2.getSelectionModel().clearSelection();

    }//GEN-LAST:event_JKRMouseEntered

    private void KMRMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_KMRMouseEntered
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        char findSymbol = lbel.getText().charAt(0);

        if (findSymbol != '<') {
            lbel.setText("N");
        }
        if (lbel.getText().equals("N")) {

            random(lbel);
        }
        deadload2.getSelectionModel().clearSelection();

    }//GEN-LAST:event_KMRMouseEntered

    private void MPRMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MPRMouseEntered
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        char findSymbol = lbel.getText().charAt(0);

        if (findSymbol != '<') {
            lbel.setText("N");
        }
        if (lbel.getText().equals("N")) {

            random(lbel);
        }
        deadload2.getSelectionModel().clearSelection();

    }//GEN-LAST:event_MPRMouseEntered

    private void PRLMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PRLMouseEntered
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        char findSymbol = lbel.getText().charAt(0);

        if (findSymbol != '<') {
            lbel.setText("N");
        }
        if (lbel.getText().equals("N")) {

            random(lbel);
        }
        deadload2.getSelectionModel().clearSelection();

    }//GEN-LAST:event_PRLMouseEntered

    private void PRRMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PRRMouseEntered
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        char findSymbol = lbel.getText().charAt(0);

        if (findSymbol != '<') {
            lbel.setText("N");
        }
        if (lbel.getText().equals("N")) {

            random(lbel);
        }
        deadload2.getSelectionModel().clearSelection();

    }//GEN-LAST:event_PRRMouseEntered

    private void CFGMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CFGMouseExited
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        pressExitDrag(lbel, "abc");
    }//GEN-LAST:event_CFGMouseExited

    private void JLGMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JLGMousePressed
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        pressExitDrag(lbel, "text");
    }//GEN-LAST:event_JLGMousePressed

    private void CFRMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CFRMousePressed
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        pressExitDrag(lbel, "text");
    }//GEN-LAST:event_CFRMousePressed

    private void CFRMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CFRMouseExited
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        pressExitDrag(lbel, "abc");
    }//GEN-LAST:event_CFRMouseExited

    private void FJRMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FJRMousePressed
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        pressExitDrag(lbel, "text");
    }//GEN-LAST:event_FJRMousePressed

    private void FJRMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FJRMouseExited
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        pressExitDrag(lbel, "abc");
    }//GEN-LAST:event_FJRMouseExited

    private void JLRMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JLRMousePressed
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        pressExitDrag(lbel, "text");
    }//GEN-LAST:event_JLRMousePressed

    private void JLRMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JLRMouseExited
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        pressExitDrag(lbel, "abc");
    }//GEN-LAST:event_JLRMouseExited

    private void LPRMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LPRMousePressed
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        pressExitDrag(lbel, "text");
    }//GEN-LAST:event_LPRMousePressed

    private void LPRMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LPRMouseExited
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        pressExitDrag(lbel, "abc");
    }//GEN-LAST:event_LPRMouseExited

    private void BCMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BCMousePressed
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        pressExitDrag(lbel, "text");
    }//GEN-LAST:event_BCMousePressed

    private void BCMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BCMouseExited
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        pressExitDrag(lbel, "abc");
    }//GEN-LAST:event_BCMouseExited

    private void CEMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CEMousePressed
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        pressExitDrag(lbel, "text");
    }//GEN-LAST:event_CEMousePressed

    private void CEMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CEMouseExited
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        pressExitDrag(lbel, "abc");


    }//GEN-LAST:event_CEMouseExited

    private void EFMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EFMousePressed
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        pressExitDrag(lbel, "text");

    }//GEN-LAST:event_EFMousePressed

    private void EFMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EFMouseExited
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        pressExitDrag(lbel, "abc");

    }//GEN-LAST:event_EFMouseExited

    private void FHMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FHMousePressed
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        pressExitDrag(lbel, "text");

    }//GEN-LAST:event_FHMousePressed

    private void FHMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FHMouseExited
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        pressExitDrag(lbel, "abc");

    }//GEN-LAST:event_FHMouseExited

    private void HJMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HJMousePressed
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        pressExitDrag(lbel, "text");

    }//GEN-LAST:event_HJMousePressed

    private void HJMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HJMouseExited
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        pressExitDrag(lbel, "abc");

    }//GEN-LAST:event_HJMouseExited

    private void JKMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JKMousePressed
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        pressExitDrag(lbel, "text");

    }//GEN-LAST:event_JKMousePressed

    private void JKMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JKMouseExited
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        pressExitDrag(lbel, "abc");

    }//GEN-LAST:event_JKMouseExited

    private void KMMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_KMMousePressed
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        pressExitDrag(lbel, "text");

    }//GEN-LAST:event_KMMousePressed

    private void KMMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_KMMouseExited
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        pressExitDrag(lbel, "abc");

    }//GEN-LAST:event_KMMouseExited

    private void MPMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MPMousePressed
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        pressExitDrag(lbel, "text");

    }//GEN-LAST:event_MPMousePressed

    private void MPMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MPMouseExited
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        pressExitDrag(lbel, "abc");

    }//GEN-LAST:event_MPMouseExited

    private void AMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AMousePressed
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        pressExitDrag(lbel, "text");

    }//GEN-LAST:event_AMousePressed

    private void AMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AMouseExited
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        pressExitDrag(lbel, "abc");

    }//GEN-LAST:event_AMouseExited

    private void BMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BMousePressed
        // TODO add your handling code here:

        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        pressExitDrag(lbel, "text");

    }//GEN-LAST:event_BMousePressed

    private void BMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BMouseExited
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        pressExitDrag(lbel, "abc");

    }//GEN-LAST:event_BMouseExited

    private void CMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CMousePressed
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        pressExitDrag(lbel, "text");

    }//GEN-LAST:event_CMousePressed

    private void CMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CMouseExited
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        pressExitDrag(lbel, "abc");

    }//GEN-LAST:event_CMouseExited

    private void DMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DMousePressed
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        pressExitDrag(lbel, "text");

    }//GEN-LAST:event_DMousePressed

    private void DMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DMouseExited
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        pressExitDrag(lbel, "abc");

    }//GEN-LAST:event_DMouseExited

    private void EMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EMousePressed
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        pressExitDrag(lbel, "text");

    }//GEN-LAST:event_EMousePressed

    private void EMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EMouseExited
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        pressExitDrag(lbel, "abc");

    }//GEN-LAST:event_EMouseExited

    private void FMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FMousePressed
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        pressExitDrag(lbel, "text");

    }//GEN-LAST:event_FMousePressed

    private void FMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FMouseExited
        // TODO add your handling code here:

        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        pressExitDrag(lbel, "abc");
    }//GEN-LAST:event_FMouseExited

    private void GMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GMousePressed
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        pressExitDrag(lbel, "text");

    }//GEN-LAST:event_GMousePressed

    private void GMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GMouseExited
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        pressExitDrag(lbel, "abc");

    }//GEN-LAST:event_GMouseExited

    private void HMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HMousePressed
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        pressExitDrag(lbel, "text");

    }//GEN-LAST:event_HMousePressed

    private void HMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HMouseExited
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        pressExitDrag(lbel, "abc");

    }//GEN-LAST:event_HMouseExited

    private void JMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JMousePressed
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        pressExitDrag(lbel, "text");

    }//GEN-LAST:event_JMousePressed

    private void JMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JMouseExited
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        pressExitDrag(lbel, "abc");

    }//GEN-LAST:event_JMouseExited

    private void KMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_KMousePressed
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        pressExitDrag(lbel, "text");

    }//GEN-LAST:event_KMousePressed

    private void KMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_KMouseExited
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        pressExitDrag(lbel, "abc");

    }//GEN-LAST:event_KMouseExited

    private void LMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LMousePressed
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        pressExitDrag(lbel, "text");

    }//GEN-LAST:event_LMousePressed

    private void LMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LMouseExited
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        pressExitDrag(lbel, "abc");

    }//GEN-LAST:event_LMouseExited

    private void MMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MMousePressed
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        pressExitDrag(lbel, "text");

    }//GEN-LAST:event_MMousePressed

    private void MMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MMouseExited
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        pressExitDrag(lbel, "abc");

    }//GEN-LAST:event_MMouseExited

    private void PMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PMousePressed
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        pressExitDrag(lbel, "text");

    }//GEN-LAST:event_PMousePressed

    private void PMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PMouseExited
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        pressExitDrag(lbel, "abc");

    }//GEN-LAST:event_PMouseExited

    private void RMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RMousePressed
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        pressExitDrag(lbel, "text");

    }//GEN-LAST:event_RMousePressed

    private void RMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RMouseExited
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        pressExitDrag(lbel, "abc");

    }//GEN-LAST:event_RMouseExited

    private void SMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SMousePressed
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        pressExitDrag(lbel, "text");

    }//GEN-LAST:event_SMousePressed

    private void SMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SMouseExited
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        pressExitDrag(lbel, "abc");

    }//GEN-LAST:event_SMouseExited

    private void TMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TMousePressed
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        pressExitDrag(lbel, "text");

    }//GEN-LAST:event_TMousePressed

    private void TMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TMouseExited
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        pressExitDrag(lbel, "abc");

    }//GEN-LAST:event_TMouseExited

    private void UMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UMousePressed
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        pressExitDrag(lbel, "text");

    }//GEN-LAST:event_UMousePressed

    private void UMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UMouseExited
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        pressExitDrag(lbel, "abc");

    }//GEN-LAST:event_UMouseExited

    private void AAMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AAMousePressed
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        pressExitDrag(lbel, "text");

    }//GEN-LAST:event_AAMousePressed

    private void AAMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AAMouseExited
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        pressExitDrag(lbel, "abc");

    }//GEN-LAST:event_AAMouseExited

    private void BBMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BBMousePressed
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        pressExitDrag(lbel, "text");

    }//GEN-LAST:event_BBMousePressed

    private void BBMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BBMouseExited
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        pressExitDrag(lbel, "abc");

    }//GEN-LAST:event_BBMouseExited

    private void CCMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CCMousePressed
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        pressExitDrag(lbel, "text");

    }//GEN-LAST:event_CCMousePressed

    private void CCMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CCMouseExited
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        pressExitDrag(lbel, "abc");

    }//GEN-LAST:event_CCMouseExited

    private void DDMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DDMousePressed
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        pressExitDrag(lbel, "text");

    }//GEN-LAST:event_DDMousePressed

    private void DDMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DDMouseExited
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        pressExitDrag(lbel, "abc");

    }//GEN-LAST:event_DDMouseExited

    private void EEMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EEMousePressed
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        pressExitDrag(lbel, "text");

    }//GEN-LAST:event_EEMousePressed

    private void EEMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EEMouseExited
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        pressExitDrag(lbel, "abc");

    }//GEN-LAST:event_EEMouseExited

    private void FFMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FFMousePressed
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        pressExitDrag(lbel, "text");

    }//GEN-LAST:event_FFMousePressed

    private void FFMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FFMouseExited
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        pressExitDrag(lbel, "abc");

    }//GEN-LAST:event_FFMouseExited

    private void GGMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GGMousePressed
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        pressExitDrag(lbel, "text");

    }//GEN-LAST:event_GGMousePressed

    private void GGMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GGMouseExited
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        pressExitDrag(lbel, "abc");

    }//GEN-LAST:event_GGMouseExited

    private void HHMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HHMousePressed
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        pressExitDrag(lbel, "text");

    }//GEN-LAST:event_HHMousePressed

    private void HHMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HHMouseExited
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        pressExitDrag(lbel, "abc");

    }//GEN-LAST:event_HHMouseExited

    private void JJMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JJMousePressed
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        pressExitDrag(lbel, "text");

    }//GEN-LAST:event_JJMousePressed

    private void JJMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JJMouseExited
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        pressExitDrag(lbel, "abc");

    }//GEN-LAST:event_JJMouseExited

    private void KKMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_KKMousePressed
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        pressExitDrag(lbel, "text");

    }//GEN-LAST:event_KKMousePressed

    private void KKMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_KKMouseExited
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        pressExitDrag(lbel, "abc");

    }//GEN-LAST:event_KKMouseExited

    private void LLMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LLMousePressed
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        pressExitDrag(lbel, "text");

    }//GEN-LAST:event_LLMousePressed

    private void LLMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LLMouseExited
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        pressExitDrag(lbel, "abc");

    }//GEN-LAST:event_LLMouseExited

    private void MMMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MMMousePressed
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        pressExitDrag(lbel, "text");

    }//GEN-LAST:event_MMMousePressed

    private void MMMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MMMouseExited
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        pressExitDrag(lbel, "abc");

    }//GEN-LAST:event_MMMouseExited

    private void PPMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PPMousePressed
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        pressExitDrag(lbel, "text");

    }//GEN-LAST:event_PPMousePressed

    private void PPMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PPMouseExited
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        pressExitDrag(lbel, "abc");

    }//GEN-LAST:event_PPMouseExited

    private void RRMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RRMousePressed
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        pressExitDrag(lbel, "text");

    }//GEN-LAST:event_RRMousePressed

    private void RRMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RRMouseExited
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        pressExitDrag(lbel, "abc");

    }//GEN-LAST:event_RRMouseExited

    private void SSMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SSMousePressed
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        pressExitDrag(lbel, "text");

    }//GEN-LAST:event_SSMousePressed

    private void SSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SSMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_SSMouseClicked

    private void SSMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SSMouseExited
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        pressExitDrag(lbel, "abc");

    }//GEN-LAST:event_SSMouseExited

    private void TTMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TTMousePressed
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        pressExitDrag(lbel, "text");

    }//GEN-LAST:event_TTMousePressed

    private void TTMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TTMouseExited
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        pressExitDrag(lbel, "abc");

    }//GEN-LAST:event_TTMouseExited

    private void ABRMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ABRMousePressed
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        pressExitDrag(lbel, "text");

    }//GEN-LAST:event_ABRMousePressed

    private void ABRMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ABRMouseExited
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        pressExitDrag(lbel, "abc");

    }//GEN-LAST:event_ABRMouseExited

    private void BCRMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BCRMousePressed
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        pressExitDrag(lbel, "text");

    }//GEN-LAST:event_BCRMousePressed

    private void BCRMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BCRMouseExited
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        pressExitDrag(lbel, "abc");

    }//GEN-LAST:event_BCRMouseExited

    private void CERMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CERMousePressed
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        pressExitDrag(lbel, "text");

    }//GEN-LAST:event_CERMousePressed

    private void CERMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CERMouseExited
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        pressExitDrag(lbel, "abc");

    }//GEN-LAST:event_CERMouseExited

    private void EFRMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EFRMousePressed
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        pressExitDrag(lbel, "text");

    }//GEN-LAST:event_EFRMousePressed

    private void EFRMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EFRMouseExited
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        pressExitDrag(lbel, "abc");

    }//GEN-LAST:event_EFRMouseExited

    private void FHRMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FHRMousePressed
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        pressExitDrag(lbel, "text");

    }//GEN-LAST:event_FHRMousePressed

    private void FHRMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FHRMouseExited
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        pressExitDrag(lbel, "abc");

    }//GEN-LAST:event_FHRMouseExited

    private void HJRMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HJRMousePressed
        // TODO add your handling code here:

        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        pressExitDrag(lbel, "text");

    }//GEN-LAST:event_HJRMousePressed

    private void HJRMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HJRMouseExited
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        pressExitDrag(lbel, "abc");

    }//GEN-LAST:event_HJRMouseExited

    private void JKRMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JKRMousePressed
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        pressExitDrag(lbel, "text");

    }//GEN-LAST:event_JKRMousePressed

    private void JKRMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JKRMouseExited
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        pressExitDrag(lbel, "abc");

    }//GEN-LAST:event_JKRMouseExited

    private void KMRMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_KMRMousePressed
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        pressExitDrag(lbel, "text");

    }//GEN-LAST:event_KMRMousePressed

    private void KMRMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_KMRMouseExited
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        pressExitDrag(lbel, "abc");

    }//GEN-LAST:event_KMRMouseExited

    private void MPRMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MPRMousePressed
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        pressExitDrag(lbel, "text");

    }//GEN-LAST:event_MPRMousePressed

    private void MPRMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MPRMouseExited
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        pressExitDrag(lbel, "abc");

    }//GEN-LAST:event_MPRMouseExited

    private void PRRMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PRRMousePressed
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        pressExitDrag(lbel, "text");

    }//GEN-LAST:event_PRRMousePressed

    private void PRRMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PRRMouseExited
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        pressExitDrag(lbel, "abc");

    }//GEN-LAST:event_PRRMouseExited

    private void ABLMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ABLMousePressed
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        pressExitDrag(lbel, "text");

    }//GEN-LAST:event_ABLMousePressed

    private void ABLMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ABLMouseExited
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        pressExitDrag(lbel, "abc");

    }//GEN-LAST:event_ABLMouseExited

    private void BCLMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BCLMousePressed
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        pressExitDrag(lbel, "text");

    }//GEN-LAST:event_BCLMousePressed

    private void BCLMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BCLMouseExited
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        pressExitDrag(lbel, "abc");

    }//GEN-LAST:event_BCLMouseExited

    private void CELMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CELMousePressed
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        pressExitDrag(lbel, "text");

    }//GEN-LAST:event_CELMousePressed

    private void CELMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CELMouseExited
        // TODO add your handling code here:

        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        pressExitDrag(lbel, "abc");

    }//GEN-LAST:event_CELMouseExited

    private void EFLMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EFLMousePressed
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        pressExitDrag(lbel, "text");

    }//GEN-LAST:event_EFLMousePressed

    private void EFLMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EFLMouseExited
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        pressExitDrag(lbel, "abc");

    }//GEN-LAST:event_EFLMouseExited

    private void FHLMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FHLMousePressed
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        pressExitDrag(lbel, "text");

    }//GEN-LAST:event_FHLMousePressed

    private void FHLMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FHLMouseExited
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        pressExitDrag(lbel, "abc");

    }//GEN-LAST:event_FHLMouseExited

    private void HJLMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HJLMousePressed
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        pressExitDrag(lbel, "text");

    }//GEN-LAST:event_HJLMousePressed

    private void HJLMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HJLMouseExited
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        pressExitDrag(lbel, "abc");

    }//GEN-LAST:event_HJLMouseExited

    private void JKLMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JKLMousePressed
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        pressExitDrag(lbel, "text");

    }//GEN-LAST:event_JKLMousePressed

    private void JKLMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JKLMouseExited
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        pressExitDrag(lbel, "abc");

    }//GEN-LAST:event_JKLMouseExited

    private void KMLMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_KMLMousePressed
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        pressExitDrag(lbel, "text");

    }//GEN-LAST:event_KMLMousePressed

    private void KMLMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_KMLMouseExited
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        pressExitDrag(lbel, "abc");

    }//GEN-LAST:event_KMLMouseExited

    private void MPLMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MPLMousePressed
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        pressExitDrag(lbel, "text");

    }//GEN-LAST:event_MPLMousePressed

    private void MPLMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MPLMouseExited
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        pressExitDrag(lbel, "abc");

    }//GEN-LAST:event_MPLMouseExited

    private void PRLMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PRLMousePressed
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        pressExitDrag(lbel, "text");

    }//GEN-LAST:event_PRLMousePressed

    private void PRLMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PRLMouseExited
        // TODO add your handling code here:
        javax.swing.JLabel lbel = (javax.swing.JLabel) evt.getComponent();
        pressExitDrag(lbel, "abc");

    }//GEN-LAST:event_PRLMouseExited

    private void distributionPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_distributionPanelMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_distributionPanelMouseClicked

    private void CFGMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CFGMouseClicked

        // TODO add your handling code here:

    }//GEN-LAST:event_CFGMouseClicked

    private void jPanel103MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel103MouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_jPanel103MouseClicked

    private void flightInfoPanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_flightInfoPanelMousePressed
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            if (FlightInfo.this.getExtendedState() == MAXIMIZED_BOTH) {
                FlightInfo.this.setExtendedState(JFrame.NORMAL);
            } else {
                FlightInfo.this.setExtendedState(MAXIMIZED_BOTH);
            }
        }

    }//GEN-LAST:event_flightInfoPanelMousePressed

    private void jLayeredPane1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLayeredPane1MousePressed
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            if (FlightInfo.this.getExtendedState() == MAXIMIZED_BOTH) {
                FlightInfo.this.setExtendedState(JFrame.NORMAL);
            } else {
                FlightInfo.this.setExtendedState(MAXIMIZED_BOTH);
            }
        }
    }//GEN-LAST:event_jLayeredPane1MousePressed

    private void distributionPanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_distributionPanelMousePressed
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            if (FlightInfo.this.getExtendedState() == MAXIMIZED_BOTH) {
                FlightInfo.this.setExtendedState(JFrame.NORMAL);
            } else {
                FlightInfo.this.setExtendedState(MAXIMIZED_BOTH);
            }
        }
    }//GEN-LAST:event_distributionPanelMousePressed

    private void unusable_fMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_unusable_fMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_unusable_fMouseClicked

    private void trip_fMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_trip_fMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_trip_fMouseClicked

    private void jTextField10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField10ActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }

            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FlightInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FlightInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FlightInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FlightInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                new FlightInfo().setVisible(true);

            }
        });

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel A;
    private javax.swing.JLabel AA;
    private javax.swing.JPanel AA_panel;
    private javax.swing.JLabel AB;
    private javax.swing.JLabel ABL;
    private javax.swing.JPanel ABL_panel;
    private javax.swing.JLabel ABR;
    private javax.swing.JPanel ABR_panel;
    private javax.swing.JPanel AB_panel;
    private javax.swing.JPanel A_panel;
    private javax.swing.JLabel B;
    private javax.swing.JLabel BB;
    private javax.swing.JPanel BB_panel;
    private javax.swing.JLabel BC;
    private javax.swing.JLabel BCL;
    private javax.swing.JPanel BCL_panel;
    private javax.swing.JLabel BCR;
    private javax.swing.JPanel BCR_panel;
    private javax.swing.JPanel BC_panel;
    private javax.swing.JPanel B_panel;
    private javax.swing.JLabel C;
    private javax.swing.JLabel CC;
    private javax.swing.JPanel CC_panel;
    private javax.swing.JLabel CE;
    private javax.swing.JLabel CEL;
    private javax.swing.JPanel CEL_panel;
    private javax.swing.JLabel CER;
    private javax.swing.JPanel CER_panel;
    private javax.swing.JPanel CE_panel;
    private javax.swing.JLabel CFG;
    private javax.swing.JPanel CFG_panel;
    private javax.swing.JLabel CFR;
    private javax.swing.JPanel CFR_panel;
    private javax.swing.JPanel C_panel;
    private javax.swing.JLabel D;
    private javax.swing.JLabel DD;
    private javax.swing.JPanel DD_panel;
    private javax.swing.JPanel D_panel;
    private javax.swing.JLabel E;
    private javax.swing.JLabel EE;
    private javax.swing.JPanel EE_panel;
    private javax.swing.JLabel EF;
    private javax.swing.JLabel EFL;
    private javax.swing.JPanel EFL_panel;
    private javax.swing.JLabel EFR;
    private javax.swing.JPanel EFR_panel;
    private javax.swing.JPanel EF_panel;
    private javax.swing.JPanel E_panel;
    private javax.swing.JLabel F;
    private javax.swing.JLabel FF;
    private javax.swing.JPanel FF_panel;
    private javax.swing.JLabel FH;
    private javax.swing.JLabel FHL;
    private javax.swing.JPanel FHL_panel;
    private javax.swing.JLabel FHR;
    private javax.swing.JPanel FHR_panel;
    private javax.swing.JPanel FH_panel;
    private javax.swing.JLabel FJG;
    private javax.swing.JPanel FJG_panel;
    private javax.swing.JLabel FJR;
    private javax.swing.JPanel FJR_panel;
    private javax.swing.JPanel F_panel;
    private javax.swing.JLabel G;
    private javax.swing.JLabel GG;
    private javax.swing.JPanel GG_panel;
    private javax.swing.JPanel G_panel;
    private javax.swing.JLabel H;
    private javax.swing.JLabel HH;
    private javax.swing.JPanel HH_panel;
    private javax.swing.JLabel HJ;
    private javax.swing.JLabel HJL;
    private javax.swing.JPanel HJL_panel;
    private javax.swing.JLabel HJR;
    private javax.swing.JPanel HJR_panel;
    private javax.swing.JPanel HJ_panel;
    private javax.swing.JPanel H_panel;
    private javax.swing.JLabel J;
    private javax.swing.JLabel JJ;
    private javax.swing.JPanel JJ_panel;
    private javax.swing.JLabel JK;
    private javax.swing.JLabel JKL;
    private javax.swing.JPanel JKL_panel;
    private javax.swing.JLabel JKR;
    private javax.swing.JPanel JKR_panel;
    private javax.swing.JPanel JK_panel;
    private javax.swing.JLabel JLG;
    private javax.swing.JPanel JLG_panel;
    private javax.swing.JLabel JLR;
    private javax.swing.JPanel JLR_panel;
    private javax.swing.JPanel J_panel;
    private javax.swing.JLabel K;
    private javax.swing.JLabel KK;
    private javax.swing.JPanel KK_panel;
    private javax.swing.JLabel KM;
    private javax.swing.JLabel KML;
    private javax.swing.JPanel KML_panel;
    private javax.swing.JLabel KMR;
    private javax.swing.JPanel KMR_panel;
    private javax.swing.JPanel KM_panel;
    private javax.swing.JPanel K_panel;
    private javax.swing.JLabel L;
    private javax.swing.JLabel LL;
    private javax.swing.JPanel LL_panel;
    private javax.swing.JLabel LPR;
    private javax.swing.JPanel LPR_panel;
    private javax.swing.JPanel L_panel;
    private javax.swing.JLabel M;
    private javax.swing.JLabel MM;
    private javax.swing.JPanel MM_panel;
    private javax.swing.JLabel MP;
    private javax.swing.JLabel MPL;
    private javax.swing.JPanel MPL_panel;
    private javax.swing.JLabel MPR;
    private javax.swing.JPanel MPR_panel;
    private javax.swing.JPanel MP_panel;
    private javax.swing.JPanel M_panel;
    private javax.swing.JLabel P;
    private javax.swing.JLabel PP;
    private javax.swing.JPanel PP_panel;
    private javax.swing.JLabel PRL;
    private javax.swing.JPanel PRL_panel;
    private javax.swing.JLabel PRR;
    private javax.swing.JPanel PRR_panel;
    private javax.swing.JPanel P_panel;
    private javax.swing.JLabel R;
    private javax.swing.JLabel RR;
    private javax.swing.JPanel RR_panel;
    private javax.swing.JPanel R_panel;
    private javax.swing.JLabel S;
    private javax.swing.JLabel SS;
    private javax.swing.JPanel SS_panel;
    private javax.swing.JPanel S_panel;
    private javax.swing.JLabel T;
    private javax.swing.JLabel TT;
    private javax.swing.JPanel TT_panel;
    private javax.swing.JPanel T_panel;
    private javax.swing.JLabel U;
    private javax.swing.JPanel U_panel;
    private javax.swing.JLabel ac_type;
    private javax.swing.JButton apply;
    private javax.swing.JTextField block_f;
    private javax.swing.JLabel block_i;
    private javax.swing.ButtonGroup buttonGroup;
    private javax.swing.JCheckBox check1;
    private javax.swing.JCheckBox check10;
    private javax.swing.JCheckBox check11;
    private javax.swing.JCheckBox check12;
    private javax.swing.JCheckBox check13;
    private javax.swing.JCheckBox check14;
    private javax.swing.JCheckBox check15;
    private javax.swing.JCheckBox check16;
    private javax.swing.JCheckBox check17;
    private javax.swing.JCheckBox check18;
    private javax.swing.JCheckBox check19;
    private javax.swing.JCheckBox check2;
    private javax.swing.JCheckBox check20;
    private javax.swing.JCheckBox check21;
    private javax.swing.JCheckBox check22;
    private javax.swing.JCheckBox check23;
    private javax.swing.JCheckBox check24;
    private javax.swing.JCheckBox check25;
    private javax.swing.JCheckBox check3;
    private javax.swing.JCheckBox check4;
    private javax.swing.JCheckBox check5;
    private javax.swing.JCheckBox check6;
    private javax.swing.JCheckBox check7;
    private javax.swing.JCheckBox check8;
    private javax.swing.JCheckBox check9;
    private javax.swing.JCheckBox checkboxMD1;
    private javax.swing.JCheckBox checkboxMD16;
    private javax.swing.JCheckBox checkboxMD2;
    private javax.swing.JCheckBox checkboxMD20;
    private javax.swing.JCheckBox checkboxMD3;
    private javax.swing.JButton closebtn;
    private javax.swing.JComboBox<String> crewCombo;
    private javax.swing.JLabel date;
    private javax.swing.JTable deadload1;
    private javax.swing.JTable deadload2;
    private javax.swing.JPanel deadloadPanel;
    private javax.swing.JComboBox<String> density_combo;
    private javax.swing.JPanel distributionPanel;
    private javax.swing.JPanel documentsPanel;
    private javax.swing.JLabel doi;
    private javax.swing.JLabel dow;
    private javax.swing.JComboBox<String> f_ac;
    private javax.swing.JButton f_create;
    private com.toedter.calendar.JDateChooser f_date;
    private javax.swing.JTextField f_dest1;
    private javax.swing.JTextField f_dest2;
    private javax.swing.JTextField f_dest3;
    private javax.swing.JTextField f_flight_no;
    private javax.swing.JTextField f_org;
    private javax.swing.JComboBox<String> f_reg;
    private javax.swing.JTextField f_std;
    private javax.swing.JPanel flightCreatorPanel;
    private javax.swing.JPanel flightInfoPanel;
    private javax.swing.JPanel flighteditPanel1;
    private javax.swing.JPanel fuelPanel;
    private javax.swing.JComboBox<String> fuel_distri_combo;
    private javax.swing.JButton fullbtn;
    private javax.swing.JRadioButton hour12;
    private javax.swing.JRadioButton hour24;
    private javax.swing.JLabel i_aft;
    private javax.swing.JLabel i_ctr;
    private javax.swing.JLabel i_f_board;
    private javax.swing.JLabel i_fwd;
    private javax.swing.JLabel i_landing;
    private javax.swing.JLabel i_trip;
    private javax.swing.JLabel i_unusable;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton28;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JComboBox<String> jComboBox8;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel115;
    private javax.swing.JLabel jLabel117;
    private javax.swing.JLabel jLabel118;
    private javax.swing.JLabel jLabel119;
    private javax.swing.JLabel jLabel120;
    private javax.swing.JLabel jLabel121;
    private javax.swing.JLabel jLabel122;
    private javax.swing.JLabel jLabel123;
    private javax.swing.JLabel jLabel124;
    private javax.swing.JLabel jLabel125;
    private javax.swing.JLabel jLabel126;
    private javax.swing.JLabel jLabel127;
    private javax.swing.JLabel jLabel128;
    private javax.swing.JLabel jLabel129;
    private javax.swing.JLabel jLabel130;
    private javax.swing.JLabel jLabel131;
    private javax.swing.JLabel jLabel132;
    private javax.swing.JLabel jLabel133;
    private javax.swing.JLabel jLabel134;
    private javax.swing.JLabel jLabel135;
    private javax.swing.JLabel jLabel136;
    private javax.swing.JLabel jLabel137;
    private javax.swing.JLabel jLabel138;
    private javax.swing.JLabel jLabel139;
    private javax.swing.JLabel jLabel140;
    private javax.swing.JLabel jLabel141;
    private javax.swing.JLabel jLabel142;
    private javax.swing.JLabel jLabel143;
    private javax.swing.JLabel jLabel144;
    private javax.swing.JLabel jLabel145;
    private javax.swing.JLabel jLabel146;
    private javax.swing.JLabel jLabel147;
    private javax.swing.JLabel jLabel148;
    private javax.swing.JLabel jLabel149;
    private javax.swing.JLabel jLabel150;
    private javax.swing.JLabel jLabel151;
    private javax.swing.JLabel jLabel152;
    private javax.swing.JLabel jLabel153;
    private javax.swing.JLabel jLabel154;
    private javax.swing.JLabel jLabel155;
    private javax.swing.JLabel jLabel156;
    private javax.swing.JLabel jLabel157;
    private javax.swing.JLabel jLabel158;
    private javax.swing.JLabel jLabel159;
    private javax.swing.JLabel jLabel160;
    private javax.swing.JLabel jLabel161;
    private javax.swing.JLabel jLabel162;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel100;
    private javax.swing.JPanel jPanel101;
    private javax.swing.JPanel jPanel102;
    private javax.swing.JPanel jPanel103;
    private javax.swing.JPanel jPanel104;
    private javax.swing.JPanel jPanel105;
    private javax.swing.JPanel jPanel106;
    private javax.swing.JPanel jPanel107;
    private javax.swing.JPanel jPanel108;
    private javax.swing.JPanel jPanel109;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel110;
    private javax.swing.JPanel jPanel111;
    private javax.swing.JPanel jPanel112;
    private javax.swing.JPanel jPanel113;
    private javax.swing.JPanel jPanel114;
    private javax.swing.JPanel jPanel115;
    private javax.swing.JPanel jPanel116;
    private javax.swing.JPanel jPanel117;
    private javax.swing.JPanel jPanel118;
    private javax.swing.JPanel jPanel119;
    private javax.swing.JPanel jPanel120;
    private javax.swing.JPanel jPanel121;
    private javax.swing.JPanel jPanel122;
    private javax.swing.JPanel jPanel123;
    private javax.swing.JPanel jPanel124;
    private javax.swing.JPanel jPanel125;
    private javax.swing.JPanel jPanel126;
    private javax.swing.JPanel jPanel127;
    private javax.swing.JPanel jPanel128;
    private javax.swing.JPanel jPanel129;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel130;
    private javax.swing.JPanel jPanel131;
    private javax.swing.JPanel jPanel132;
    private javax.swing.JPanel jPanel133;
    private javax.swing.JPanel jPanel134;
    private javax.swing.JPanel jPanel135;
    private javax.swing.JPanel jPanel136;
    private javax.swing.JPanel jPanel137;
    private javax.swing.JPanel jPanel138;
    private javax.swing.JPanel jPanel139;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel140;
    private javax.swing.JPanel jPanel141;
    private javax.swing.JPanel jPanel142;
    private javax.swing.JPanel jPanel143;
    private javax.swing.JPanel jPanel144;
    private javax.swing.JPanel jPanel145;
    private javax.swing.JPanel jPanel146;
    private javax.swing.JPanel jPanel147;
    private javax.swing.JPanel jPanel148;
    private javax.swing.JPanel jPanel149;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel150;
    private javax.swing.JPanel jPanel151;
    private javax.swing.JPanel jPanel152;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel jPanel91;
    private javax.swing.JPanel jPanel92;
    private javax.swing.JPanel jPanel93;
    private javax.swing.JPanel jPanel94;
    private javax.swing.JPanel jPanel95;
    private javax.swing.JPanel jPanel96;
    private javax.swing.JPanel jPanel97;
    private javax.swing.JPanel jPanel98;
    private javax.swing.JPanel jPanel99;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable5;
    private javax.swing.JTable jTable6;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField18;
    private javax.swing.JTextField jTextField19;
    private javax.swing.JTextField jTextField20;
    private javax.swing.JPanel leteralImbalancePanel;
    private javax.swing.JButton list1;
    private javax.swing.JButton list10;
    private javax.swing.JButton list11;
    private javax.swing.JButton list12;
    private javax.swing.JButton list13;
    private javax.swing.JButton list14;
    private javax.swing.JButton list15;
    private javax.swing.JButton list16;
    private javax.swing.JButton list17;
    private javax.swing.JButton list18;
    private javax.swing.JButton list19;
    private javax.swing.JButton list2;
    private javax.swing.JButton list20;
    private javax.swing.JButton list21;
    private javax.swing.JButton list22;
    private javax.swing.JButton list23;
    private javax.swing.JButton list24;
    private javax.swing.JButton list25;
    private javax.swing.JButton list3;
    private javax.swing.JButton list4;
    private javax.swing.JButton list5;
    private javax.swing.JButton list6;
    private javax.swing.JButton list7;
    private javax.swing.JButton list8;
    private javax.swing.JButton list9;
    private javax.swing.JPanel lmcPanel;
    private javax.swing.JButton logout;
    private javax.swing.JButton minimizebtn;
    private javax.swing.JComboBox<String> more;
    private javax.swing.JPanel p1;
    private javax.swing.JPanel p10;
    private javax.swing.JPanel p11;
    private javax.swing.JPanel p12;
    private javax.swing.JPanel p13;
    private javax.swing.JPanel p14;
    private javax.swing.JPanel p15;
    private javax.swing.JPanel p16;
    private javax.swing.JPanel p17;
    private javax.swing.JPanel p18;
    private javax.swing.JPanel p19;
    private javax.swing.JPanel p2;
    private javax.swing.JPanel p20;
    private javax.swing.JPanel p21;
    private javax.swing.JPanel p22;
    private javax.swing.JPanel p23;
    private javax.swing.JPanel p24;
    private javax.swing.JPanel p25;
    private javax.swing.JPanel p3;
    private javax.swing.JPanel p4;
    private javax.swing.JPanel p5;
    private javax.swing.JPanel p6;
    private javax.swing.JPanel p7;
    private javax.swing.JPanel p8;
    private javax.swing.JPanel p9;
    private javax.swing.JLabel p_ldw;
    private javax.swing.JLabel p_tow;
    private javax.swing.JLabel p_zemac;
    private javax.swing.JLabel p_zfw;
    private javax.swing.JComboBox<String> regCombo;
    private javax.swing.JLabel route;
    private javax.swing.JPanel selectFlightPanel;
    private javax.swing.JLabel std;
    private javax.swing.JTextField taxi_f;
    private javax.swing.JLabel timeClock;
    private javax.swing.JLabel title;
    private javax.swing.JTextField trip_f;
    private javax.swing.JLabel trip_i;
    private javax.swing.JButton unload;
    private javax.swing.JTextField unusable_f;
    private javax.swing.JLabel unusable_i;
    private javax.swing.JLabel w_aft;
    private javax.swing.JLabel w_ctr;
    private javax.swing.JLabel w_f_board;
    private javax.swing.JLabel w_fwd;
    private javax.swing.JLabel w_landing;
    private javax.swing.JLabel w_taxi;
    private javax.swing.JLabel w_trip;
    private javax.swing.JLabel w_unusable;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {

        if (hour12.isSelected()) {
            jPanel4.setVisible(false);
            while (true) {
                if (hour12.isSelected() == false) {
                    run();
                }
                Calendar cal = Calendar.getInstance();
                hour = cal.get(Calendar.HOUR_OF_DAY);
                minute = cal.get(Calendar.MINUTE);
                second1 = cal.get(Calendar.SECOND);

                SimpleDateFormat s = new SimpleDateFormat("hh:mm:ss aa");
                Date dat = cal.getTime();
                String time = s.format(dat);

                timeClock.setText(time);
            }
        }
        if (hour24.isSelected()) {

            jPanel4.setVisible(false);
            while (true) {
                if (hour24.isSelected() == false) {
                    run();
                }
                Calendar cal = Calendar.getInstance();
                hour = cal.get(Calendar.HOUR_OF_DAY);
                minute = cal.get(Calendar.MINUTE);
                second1 = cal.get(Calendar.SECOND);

                SimpleDateFormat s = new SimpleDateFormat("HH:mm:ss");
                Date dat = cal.getTime();
                String time = s.format(dat);

                timeClock.setText(time);
            }
        }

    }
}

abstract class StringTransferHandler extends TransferHandler {

    protected abstract String exportString(JComponent c);

    protected abstract void importString(JComponent c, String str);

    protected abstract void cleanup(JComponent c, boolean remove);

    protected Transferable createTransferable(JComponent c) {
        return new StringSelection(exportString(c));
    }

    public int getSourceActions(JComponent c) {
        return COPY_OR_MOVE;
    }

    public boolean importData(JComponent c, Transferable t) {
        if (canImport(c, t.getTransferDataFlavors())) {
            try {
                String str = (String) t.getTransferData(DataFlavor.stringFlavor);
                importString(c, str);
                return true;
            } catch (UnsupportedFlavorException ufe) {
            } catch (IOException ioe) {
            }
        }

        return false;
    }

    protected void exportDone(JComponent c, Transferable data, int action) {
        cleanup(c, action == MOVE);
    }

    public boolean canImport(JComponent c, DataFlavor[] flavors) {
        for (int i = 0; i < flavors.length; i++) {
            if (DataFlavor.stringFlavor.equals(flavors[i])) {
                return true;
            }
        }
        return false;
    }
}

class TableTransferHandler extends StringTransferHandler {

    private int[] rows = null;
    private int addIndex = -1; //Location where items were added
    private int addCount = 0;  //Number of items added.

    protected String exportString(JComponent c) {
        JTable table = (JTable) c;
        rows = table.getSelectedRows();
        int colCount = table.getColumnCount();

        StringBuffer buff = new StringBuffer();

        for (int i = 0; i < rows.length; i++) {
            for (int j = 0; j < colCount; j++) {
                Object val = table.getValueAt(rows[i], j);
                buff.append(val == null ? "" : val.toString());
                if (j != colCount - 1) {
                    buff.append(",");
                }
            }
            if (i != rows.length - 1) {
                buff.append("\n");
            }
        }

        return buff.toString();
    }

    protected void importString(JComponent c, String str) {
        JTable target = (JTable) c;
        DefaultTableModel model = (DefaultTableModel) target.getModel();
        int index = target.getSelectedRow();

        //Prevent the user from dropping data back on itself.
        //For example, if the user is moving rows #4,#5,#6 and #7 and
        //attempts to insert the rows after row #5, this would
        //be problematic when removing the original rows.
        //So this is not allowed.
        if (rows != null && index >= rows[0] - 1
                && index <= rows[rows.length - 1]) {
            rows = null;
            return;
        }

        int max = model.getRowCount();
        if (index < 0) {
            index = max;
        } else {
            index++;
            if (index > max) {
                index = max;
            }
        }
        addIndex = index;
        String[] values = str.split("\n");
        addCount = values.length;
        int colCount = target.getColumnCount();
        for (int i = 0; i < values.length && i < colCount; i++) {
            model.insertRow(index++, values[i].split(","));
        }
    }

    protected void cleanup(JComponent c, boolean remove) {
        JTable source = (JTable) c;
        if (remove && rows != null) {
            DefaultTableModel model
                    = (DefaultTableModel) source.getModel();

            //If we are moving items around in the same table, we
            //need to adjust the rows accordingly, since those
            //after the insertion point have moved.
            if (addCount > 0) {
                for (int i = 0; i < rows.length; i++) {
                    if (rows[i] > addIndex) {
                        rows[i] += addCount;
                    }
                }
            }
            for (int i = rows.length - 1; i >= 0; i--) {
                model.removeRow(rows[i]);
            }
        }
        rows = null;
        addCount = 0;
        addIndex = -1;
    }
}
