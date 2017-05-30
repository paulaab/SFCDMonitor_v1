package de.vodafone.innogarage.sfcdmonitoring;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ScannerTask extends AsyncTask<ConnectionManager, Void, List<String>> {



    @Override
    protected List<String> doInBackground(ConnectionManager... params) {

        ConnectionManager conMan = null;
        if(params.length == 1)
            conMan = params[0];

        Connection con = null;
        List<JSONObject> msgList = null;
        JSONObject actMsg = null;
        CopyOnWriteArrayList<String> rs = new CopyOnWriteArrayList<>();
        List<Connection> cons = null;

        if(!conMan.getConnections().isEmpty()){

            cons = conMan.getConnections();


            if(con == null){
                con = cons.get(0);
            }

            msgList = con.getIncomingData();

            if(!msgList.isEmpty()) {

                System.out.print("Received msglist");
                actMsg = msgList.get(0);



                msgList.remove(0);

                String  name = null,
                        temperature = null,
                        currenttime = null,
                        resetcounter = null,
                        mode = null,
                        systemmode = null,
                        psstate = null,
                        lteband = null,
                        ltebw = null,
                        imsregstate = null,
                        lterxchan  = null,
                        ltetxchan = null,
                        ltecastate = null,
                        emmstate = null,
                        rrcstate = null,
                        rxmrssi = null,
                        rxmrsrp = null,
                        txpower = null,
                        rxdrssi = null,
                        rxdrsrp = null,
                        tac = null,
                        rsrq = null,
                        sinr = null,
                        cellid = null,
                        //Serving
                        earfcn = null,
                        mcc = null,
                        mnc = null,
                        tacserv = null,
                        cid = null,
                        bd = null,
                        d = null,
                        u = null,
                        snr = null,
                        pci = null,
                        rsrqserv = null,
                        rsrp = null,
                        rssi = null,
                        rxlv = null,
                        //Interfeq
                        earfcnint = null,
                        thlow = null,
                        thhi = null,
                        priority = null,
                        pciint = null,
                        rsrqint = null,
                        rsrpint = null,
                        rssiint = null,
                        rxlvint = null,
                        //Intrafreq
                        pciinta = null,
                        rsrqinta = null,
                        rsrpinta = null,
                        rssiinta = null,
                        rxlvinta = null,
                        //Location
                        alti = null,
                        longi = null,
                        lati = null,
                        speed = null,
                        eps = null,
                        epx = null,
                        epv = null,
                        ept = null,
                        climb = null,
                        track = null,
                        modeloc = null,
                        satellites = null;




                try {
                    name = con.getName();

                    temperature =   actMsg.getJSONObject("gstatus").getString("temperature");
                    currenttime =   actMsg.getJSONObject("gstatus").getString("currenttime");
                    resetcounter =  actMsg.getJSONObject("gstatus").getString("resetcounter");
                    mode =          actMsg.getJSONObject("gstatus").getString("mode");
                    systemmode =    actMsg.getJSONObject("gstatus").getString("systemmode");
                    psstate =       actMsg.getJSONObject("gstatus").getString("psstate");
                    lteband =       actMsg.getJSONObject("gstatus").getString("lteband");
                    ltebw =         actMsg.getJSONObject("gstatus").getString("ltebw(mhz)");
                    imsregstate =   actMsg.getJSONObject("gstatus").getString("imsregstate");
                    lterxchan  =    actMsg.getJSONObject("gstatus").getString("lterxchan");
                    ltetxchan =     actMsg.getJSONObject("gstatus").getString("ltetxchan");
                    ltecastate =    actMsg.getJSONObject("gstatus").getString("ltecastate");
                    emmstate =      actMsg.getJSONObject("gstatus").getString("emmstatereg");
                    rrcstate =      actMsg.getJSONObject("gstatus").getString("rrcstate");
                    rxmrssi =       actMsg.getJSONObject("gstatus").getString("pccrxmrssi");
                    txpower =       actMsg.getJSONObject("gstatus").getString("txpower");
                    rxdrssi =       actMsg.getJSONObject("gstatus").getString("pccrxdrssi");
                    tac =           actMsg.getJSONObject("gstatus").getString("tac");
                    rsrq =          actMsg.getJSONObject("gstatus").getString("rsrq(db)");
                    sinr =          actMsg.getJSONObject("gstatus").getString("sinr(db)");
                    cellid =        actMsg.getJSONObject("gstatus").getString("cellid");
                    rxmrsrp =       actMsg.getJSONObject("gstatus").getString("rsrp(dbm)pccrxmrssi");
                    rxdrsrp=        actMsg.getJSONObject("gstatus").getString("rsrp(dbm)pccrxdrssi");

                        /*
                        String[] tempX =  removeJSONShit(actMsg.getString("RSRP (dBm)")).split(",");

                        rxmrsrp = tempX[0].substring(0,tempX[0].length()-1) ;
                        rxdrsrp = tempX[1].substring(1,tempX[1].length()) ;*/

                    //Serving
                    earfcn =    actMsg.getJSONArray("serving").getJSONObject(0).getString("EARFCN");
                    mcc = actMsg.getJSONArray("serving").getJSONObject(0).getString("MCC");
                    mnc = actMsg.getJSONArray("serving").getJSONObject(0).getString("MNC");
                    tacserv = actMsg.getJSONArray("serving").getJSONObject(0).getString("TAC");
                    cid = actMsg.getJSONArray("serving").getJSONObject(0).getString("CID");
                    bd = actMsg.getJSONArray("serving").getJSONObject(0).getString("Bd");
                    d = actMsg.getJSONArray("serving").getJSONObject(0).getString("D");
                    u = actMsg.getJSONArray("serving").getJSONObject(0).getString("U");
                    snr = actMsg.getJSONArray("serving").getJSONObject(0).getString("SNR");
                    pci = actMsg.getJSONArray("serving").getJSONObject(0).getString("PCI");
                    rsrqserv = actMsg.getJSONArray("serving").getJSONObject(0).getString("RSRQ");
                    rsrp = actMsg.getJSONArray("serving").getJSONObject(0).getString("RSRP");
                    rssi = actMsg.getJSONArray("serving").getJSONObject(0).getString("RSSI");
                    rxlv = actMsg.getJSONArray("serving").getJSONObject(0).getString("RXLV");
                    //Interfeq
                    /*

                    earfcnint = actMsg.getJSONArray("interfreq").getJSONObject(0).getString("EARFCN");
                    thlow = actMsg.getJSONArray("interfreq").getJSONObject(0).getString("ThresholdLow");
                    thhi = actMsg.getJSONArray("interfreq").getJSONObject(0).getString("ThresholdHi");
                    priority = actMsg.getJSONArray("interfreq").getJSONObject(0).getString("Priority");
                    pciint = actMsg.getJSONArray("interfreq").getJSONObject(0).getString("PCI");
                    rsrqint = actMsg.getJSONArray("interfreq").getJSONObject(0).getString("RSRQ");
                    rsrpint = actMsg.getJSONArray("interfreq").getJSONObject(0).getString("RSRP");
                    rssiint = actMsg.getJSONArray("interfreq").getJSONObject(0).getString("RSSI");
                    rxlvint = actMsg.getJSONArray("interfreq").getJSONObject(0).getString("RXLV");

                    */
                    //Intrafreq
                    pciinta = actMsg.getJSONArray("intrafreq").getJSONObject(0).getString("PCI");
                    rsrqinta = actMsg.getJSONArray("intrafreq").getJSONObject(0).getString("RSRQ");
                    rsrpinta = actMsg.getJSONArray("intrafreq").getJSONObject(0).getString("RSRP");
                    rssiinta = actMsg.getJSONArray("intrafreq").getJSONObject(0).getString("RSSI");
                    rxlvinta = actMsg.getJSONArray("intrafreq").getJSONObject(0).getString("RXLV");
                    //Location
                    alti = actMsg.getJSONObject("location").getString("altitude");
                    longi = actMsg.getJSONObject("location").getString("longitude");
                    lati = actMsg.getJSONObject("location").getString("latitude");
                    speed = actMsg.getJSONObject("location").getString("speed");
                    eps = actMsg.getJSONObject("location").getString("eps");
                    epx = actMsg.getJSONObject("location").getString("epx");
                    epv = actMsg.getJSONObject("location").getString("epv");
                    ept = actMsg.getJSONObject("location").getString("ept");
                    climb = actMsg.getJSONObject("location").getString("climb");
                    track = actMsg.getJSONObject("location").getString("track");
                    modeloc = actMsg.getJSONObject("location").getString("mode");
                    satellites = actMsg.getJSONObject("location").getString("satellites");








                } catch (JSONException e) {
                    e.printStackTrace();
                }

                if(name != null) rs.add(name);
                else rs.add("UNKNOWN");



                if(temperature != null) rs.add(temperature);
                else rs.add("N/A!");

                if(currenttime != null) rs.add(currenttime);
                else rs.add("N/A!");

                if(resetcounter != null) rs.add(resetcounter);
                else rs.add("N/A!");

                if(mode != null) rs.add(mode);
                else rs.add("N/A!");

                if(systemmode != null) rs.add(systemmode);
                else rs.add("N/A!");

                if(psstate != null) rs.add(psstate);
                else rs.add("N/A!");

                if(lteband != null) rs.add(lteband);
                else rs.add("N/A!");

                if(ltebw != null) rs.add(ltebw);
                else rs.add("N/A!");

                if(imsregstate != null) rs.add(imsregstate);
                else rs.add("N/A!");

                if(lterxchan != null) rs.add(lterxchan);
                else rs.add("N/A!");

                if(ltetxchan != null) rs.add(ltetxchan);
                else rs.add("N/A!");

                if(ltecastate != null) rs.add(ltecastate);
                else rs.add("N/A!");

                if(emmstate != null) rs.add(emmstate);
                else rs.add("N/A!");

                if(rrcstate != null) rs.add(rrcstate);
                else rs.add("N/A!");

                if(rxmrssi != null) rs.add(rxmrssi);
                else rs.add("N/A!");

                if(txpower != null) rs.add(txpower);
                else rs.add("N/A!");

                if(rxdrssi != null) rs.add(rxdrssi);
                else rs.add("N/A!");

                if(tac != null) rs.add(tac);
                else rs.add("N/A!");

                if(rsrq != null) rs.add(rsrq);
                else rs.add("N/A!");

                if(sinr != null) rs.add(sinr);
                else rs.add("N/A!");

                if(cellid != null) rs.add(cellid);
                else rs.add("N/A!");

                if(rxmrsrp != null) rs.add(rxmrsrp);
                else rs.add("N/A!");

                if(rxdrsrp != null) rs.add(rxdrsrp);
                else rs.add("N/A!");

                if(earfcn != null) rs.add(earfcn);
                else rs.add("N/A!");
                if(mcc != null) rs.add(mcc);
                else rs.add("N/A!");
                if(mnc != null) rs.add(mnc);
                else rs.add("N/A!");
                if(tacserv != null) rs.add(tacserv);
                else rs.add("N/A!");
                if(cid != null) rs.add(cid);
                else rs.add("N/A!");
                if(bd != null) rs.add(bd);
                else rs.add("N/A!");
                if(d != null) rs.add(d);
                else rs.add("N/A!");
                if(u != null) rs.add(u);
                else rs.add("N/A!");
                if(snr != null) rs.add(snr);
                else rs.add("N/A!");
                if(pci != null) rs.add(pci);
                else rs.add("N/A!");
                if(rsrqserv != null) rs.add(rsrqserv);
                else rs.add("N/A!");
                if(rsrp != null) rs.add(rsrp);
                else rs.add("N/A!");
                if(rssi != null) rs.add(rssi);
                else rs.add("N/A!");
                if(rxlv != null) rs.add(rxlv);
                else rs.add("N/A!");
                //interfreq

                if(earfcnint != null) rs.add(earfcnint);
                else rs.add("N/A!");
                if(thlow != null) rs.add(thlow);
                else rs.add("N/A!");
                if(thhi != null) rs.add(thhi);
                else rs.add("N/A!");
                if(priority != null) rs.add(priority);
                else rs.add("N/A!");
                if(pciint != null) rs.add(pciint);
                else rs.add("N/A!");
                if(rsrqint != null) rs.add(rsrqint);
                else rs.add("N/A!");
                if(rsrpint != null) rs.add(rsrpint);
                else rs.add("N/A!");
                if(rssiint != null) rs.add(rssiint);
                else rs.add("N/A!");
                if(rxlvint != null) rs.add(rxlvint);
                else rs.add("N/A!");
                //intrafreq
                if(pciinta != null) rs.add(pciinta);
                else rs.add("N/A!");
                if(rsrqinta != null) rs.add(rsrqinta);
                else rs.add("N/A!");
                if(rsrpinta != null) rs.add(rsrpinta);
                else rs.add("N/A!");
                if(rssiinta != null) rs.add(rssiinta);
                else rs.add("N/A!");
                if(rxlvinta != null) rs.add(rxlvinta);
                else rs.add("N/A!");
                //Location
                if(alti != null) rs.add(alti);
                else rs.add("N/A!");
                if(longi != null) rs.add(longi);
                else rs.add("N/A!");
                if(lati != null) rs.add(lati);
                else rs.add("N/A!");
                if(speed != null) rs.add(speed);
                else rs.add("N/A!");
                if(eps != null) rs.add(eps);
                else rs.add("N/A!");
                if(epx != null) rs.add(epx);
                else rs.add("N/A!");
                if(epv != null) rs.add(epv);
                else rs.add("N/A!");
                if(ept != null) rs.add(ept);
                else rs.add("N/A!");
                if(climb != null) rs.add(climb);
                else rs.add("N/A!");
                if(track != null) rs.add(track);
                else rs.add("N/A!");
                if(modeloc != null) rs.add(modeloc);
                else rs.add("N/A!");
                if(satellites != null) rs.add(satellites);
                else rs.add("N/A!");

            }
        }
        return rs;
    }


}