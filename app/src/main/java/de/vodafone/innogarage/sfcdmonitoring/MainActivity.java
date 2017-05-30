package de.vodafone.innogarage.sfcdmonitoring;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.xml.transform.Result;

public class MainActivity extends AppCompatActivity {
    //Define socket variables (ports)
    public static boolean debugMode = true;
    public static int socketPortForBroadcast = 45555;
    public static int socketServerPortForSFCD = 45556;
    //Define variables for connection
    ConnectionManager conMan = new ConnectionManager();
    List<Connection> cons = conMan.getConnections();
    TimerTask timerTask;
    Timer timer = new Timer();







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //globalContext = this;

        final Button button = (Button) findViewById(R.id.buttonInvitation);
        button.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){

                conMan.sendInvitation();
            }
        });



        // TODO: check if this works, if so remove it
        // does not work properly with the given software structure
        // new Inviter().start();

        timerTask = new TimerTask() {

            public void run() {
                new ScannerTask() {

                    protected void onPostExecute(List<String> result) {

                        if (!cons.isEmpty() &&!result.isEmpty()) {

                            //ListView liste = (ListView) findViewById(R.id.lv_SFCDListe);
                            //liste.setAdapter(new ListViewAdapter(globalConext, conMan));

                            //GSTATUS
                            TextView temp = (TextView) findViewById(R.id.sfcdname);
                            temp.setText(result.get(0));
                            temp.setText(result.remove(0));
                            temp = (TextView) findViewById(R.id.temperature);
                            temp.setText(result.remove(0));
                            temp = (TextView) findViewById(R.id.currenttime);
                            temp.setText(result.remove(0));
                            temp = (TextView) findViewById(R.id.resetcounter);
                            temp.setText(result.remove(0));
                            temp = (TextView) findViewById(R.id.mode);
                            temp.setText(result.remove(0));
                            temp = (TextView) findViewById(R.id.systemmode);
                            temp.setText(result.remove(0));
                            temp = (TextView) findViewById(R.id.psstate);
                            temp.setText(result.remove(0));
                            temp = (TextView) findViewById(R.id.lteband);
                            temp.setText(result.remove(0));
                            temp = (TextView) findViewById(R.id.ltebw);
                            temp.setText(result.remove(0));
                            temp = (TextView) findViewById(R.id.imsregstate);
                            temp.setText(result.remove(0));
                            temp = (TextView) findViewById(R.id.lterxchan);
                            temp.setText(result.remove(0));
                            temp = (TextView) findViewById(R.id.ltetxchan);
                            temp.setText(result.remove(0));
                            temp = (TextView) findViewById(R.id.ltecastate);
                            temp.setText(result.remove(0));
                            temp = (TextView) findViewById(R.id.emmstate);
                            temp.setText(result.remove(0));
                            temp = (TextView) findViewById(R.id.rrcstate);
                            temp.setText(result.remove(0));
                            temp = (TextView) findViewById(R.id.rxmrssi);
                            temp.setText(result.remove(0));
                            temp = (TextView) findViewById(R.id.txpower);
                            temp.setText(result.remove(0));
                            temp = (TextView) findViewById(R.id.rxdrssi);
                            temp.setText(result.remove(0));
                            temp = (TextView) findViewById(R.id.tac);
                            temp.setText(result.remove(0));
                            temp = (TextView) findViewById(R.id.rsrq2);
                            temp.setText(result.remove(0));
                            temp = (TextView) findViewById(R.id.sinr);
                            temp.setText(result.remove(0));
                            temp = (TextView) findViewById(R.id.cellid);
                            temp.setText(result.remove(0));
                            temp = (TextView) findViewById(R.id.rxmrsrp);
                            temp.setText(result.remove(0));
                            temp = (TextView) findViewById(R.id.rxdrsrp);
                            temp.setText(result.remove(0));

                            //"Serving" part
                            temp = (TextView) findViewById(R.id.earfcn);
                            temp.setText(result.remove(0));
                            temp = (TextView) findViewById(R.id.mcc);
                            temp.setText(result.remove(0));
                            temp = (TextView) findViewById(R.id.mnc);
                            temp.setText(result.remove(0));
                            temp = (TextView) findViewById(R.id.tac2);
                            temp.setText(result.remove(0));
                            temp = (TextView) findViewById(R.id.cid);
                            temp.setText(result.remove(0));
                            temp = (TextView) findViewById(R.id.bd);
                            temp.setText(result.remove(0));
                            temp = (TextView) findViewById(R.id.d);
                            temp.setText(result.remove(0));
                            temp = (TextView) findViewById(R.id.u);
                            temp.setText(result.remove(0));
                            temp = (TextView) findViewById(R.id.snr);
                            temp.setText(result.remove(0));
                            temp = (TextView) findViewById(R.id.pci);
                            temp.setText(result.remove(0));
                            temp = (TextView) findViewById(R.id.rsrq);
                            temp.setText(result.remove(0));
                            temp = (TextView) findViewById(R.id.rsrp);
                            temp.setText(result.remove(0));
                            temp = (TextView) findViewById(R.id.rssi);
                            temp.setText(result.remove(0));
                            temp = (TextView) findViewById(R.id.rxlv);
                            //Interfreq
                            temp.setText(result.remove(0));
                            temp = (TextView) findViewById(R.id.earfcnint);
                            temp.setText(result.remove(0));
                            temp = (TextView) findViewById(R.id.thlow);
                            temp.setText(result.remove(0));
                            temp = (TextView) findViewById(R.id.thhi);
                            temp.setText(result.remove(0));
                            temp = (TextView) findViewById(R.id.proirity);
                            temp.setText(result.remove(0));
                            temp = (TextView) findViewById(R.id.pci);
                            temp.setText(result.remove(0));
                            temp = (TextView) findViewById(R.id.rsrqint);
                            temp.setText(result.remove(0));
                            temp = (TextView) findViewById(R.id.rsrpint);
                            temp.setText(result.remove(0));
                            temp = (TextView) findViewById(R.id.rssiint);
                            temp.setText(result.remove(0));
                            temp = (TextView) findViewById(R.id.rxlvint);
                            temp.setText(result.remove(0));
                            //Intrafreq
                            temp = (TextView) findViewById(R.id.pciinta);
                            temp.setText(result.remove(0));
                            temp = (TextView) findViewById(R.id.rsrqinta);
                            temp.setText(result.remove(0));
                            temp = (TextView) findViewById(R.id.rsrpinta);
                            temp.setText(result.remove(0));
                            temp = (TextView) findViewById(R.id.rssiinta);
                            temp.setText(result.remove(0));
                            temp = (TextView) findViewById(R.id.rxlvinta);
                            temp.setText(result.remove(0));
                            //Location
                            temp = (TextView) findViewById(R.id.alti);
                            temp.setText(result.remove(0));
                            temp = (TextView) findViewById(R.id.longi);
                            temp.setText(result.remove(0));
                            temp = (TextView) findViewById(R.id.lati);
                            temp.setText(result.remove(0));
                            temp = (TextView) findViewById(R.id.speed);
                            temp.setText(result.remove(0));
                            temp = (TextView) findViewById(R.id.eps);
                            temp.setText(result.remove(0));
                            temp = (TextView) findViewById(R.id.epx);
                            temp.setText(result.remove(0));
                            temp = (TextView) findViewById(R.id.epv);
                            temp.setText(result.remove(0));
                            temp = (TextView) findViewById(R.id.ept);
                            temp.setText(result.remove(0));
                            temp = (TextView) findViewById(R.id.climb);
                            temp.setText(result.remove(0));
                            temp = (TextView) findViewById(R.id.track);
                            temp.setText(result.remove(0));
                            temp = (TextView) findViewById(R.id.mode2);
                            temp.setText(result.remove(0));
                            temp = (TextView) findViewById(R.id.satellites);
                            temp.setText(result.remove(0));
                        }
                    }
                }.execute(conMan);
            }
        };
        timer.schedule(timerTask, 0, 200);

    }
}
