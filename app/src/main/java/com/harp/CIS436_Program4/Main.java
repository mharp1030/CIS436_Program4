package com.harp.CIS436_Program4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Main extends Activity implements View.OnClickListener
{
    private TextView txtHeader, txtDesc;
    private ImageView img;
    private int current = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnChangeTxt, btnNext;

        btnChangeTxt = findViewById(R.id.getDealBtn);
        txtHeader = findViewById(R.id.subHeaderText);
        txtDesc = findViewById(R.id.subHeadingText);
        img = findViewById(R.id.appImage);
        btnNext = findViewById(R.id.DealBtn);

        btnChangeTxt.setOnClickListener(this);
        btnNext.setOnClickListener(this);

        if (savedInstanceState != null) {
            current = savedInstanceState.getInt("Value");
            if(current != 5)
            {
                current--;
            }
        }

        btnChangeTxt.performClick();
    }

    @Override
    protected void onSaveInstanceState (Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("Value", current);
    }

    // One card that gets updated with new data
    @Override
    public void onClick(View v)
    {
        switch(v.getId())
        {
            case R.id.getDealBtn:
                switch(current)
                {
                    case 0:
                        img.setImageResource(R.drawable.hulk);
                        txtHeader.setText("The Hulk: Bruce Banner");
                        txtDesc.setText("Caught in the blast of gamma radiation, brilliant scientist" +
                                " Bruce Banner is cursed to transform in times of stress into the" +
                                " indestructible living engine of destruction known as The Hulk.");
                        current++;
                        break;
                    case 1:
                        img.setImageResource(R.drawable.greenarrow);
                        txtHeader.setText("Green Arrow: Oliver Queen");
                        txtDesc.setText("A vigilante superhero who fights crime using archery," +
                                " martial arts and technology. In his secret identity he is Oliver" +
                                " Queen, living in Star City as a wealthy playboy and billionaire" +
                                " industrialist turned outspoken socially-progressive politician.");
                        current++;
                        break;
                    case 2:
                        img.setImageResource(R.drawable.firestorm);
                        txtHeader.setText("Firestorm: Ronnie Raymound, Martin Stein");
                        txtDesc.setText("A nuclear-powered superhero with the ability to transmute" +
                                " elements. The Firestorm Matrix is a composite of multiple people" +
                                " bonded together, high school student Ronnie Raymond controlling" +
                                " the body and nuclear physicist Professor Martin Stein giving" +
                                " direction as an additional consciousness.");
                        current++;
                        break;
                    case 3:
                        img.setImageResource(R.drawable.deathstroke);
                        txtHeader.setText("Deathstroke: Slade Wilson");
                        txtDesc.setText("Possesses enhanced strength, speed, agility, and durability" +
                                " granted by an experimental serum. Deathstroke also" +
                                " possesses a healing factor in his blood that enables him to recover from" +
                                " physical injury much faster than a normal person. Deathstroke is also a" +
                                " formidable martial artist and hand-to-hand combatant.");
                        current++;
                        break;
                    case 4:
                        img.setImageResource(R.drawable.punisher);
                        txtHeader.setText("The Punisher: Frank Castle");
                        txtDesc.setText("A violent vigilante and former United States Marine," +
                                " who joined Cerberus Squad while he was still serving in Afghanistan." +
                                " Castle returned to his family, only to lose them all during a" +
                                " brutal shooting. Castle then became the Punisher, aiming to" +
                                " clean up New York City of crime by any means necessary.");
                        current++;
                        break;
                    default:
                        img.setImageResource(R.drawable.flash);
                        txtHeader.setText("The Flash: Barry Allen");
                        txtDesc.setText("Barry Allen is the fastest man alive. In his secret identity he is a police" +
                                " officer working in Central City as a forensics specialist. Barry's running" +
                                " generates the Speed Force, an enigmatic source of energy that all other speedsters" +
                                " tap into throughout time. There is an ever-present danger that as fast as he" +
                                " runs, he might lose himself as he approaches speeds closer to light, but his" +
                                " lightning rod is his wife Iris West.");
                        current = 0;
                }
                break;
            case R.id.DealBtn:
                startActivity(new Intent(Main.this, RecyclerActivity.class));
                break;
        }

    }
}
