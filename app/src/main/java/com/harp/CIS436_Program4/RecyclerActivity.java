package com.harp.CIS436_Program4;

import android.support.v7.widget.Toolbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class RecyclerActivity extends AppCompatActivity  {

    private List<Movies> movies;
    private RecyclerView rv;
    int current = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);

        rv = findViewById(R.id.rv);

        Toolbar toolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Marvel Movies");

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rv.setLayoutManager(linearLayoutManager);
        rv.setHasFixedSize(true);

        if (savedInstanceState != null) {
            current = savedInstanceState.getInt("Value");
        }

        initializeData();
    }

    //adds content to be displayed in activity
    private void initializeData()
    {
        movies = new ArrayList<>();
        DataAdapter db;
        clear();
        switch(current)
        {
            case 0:
                getSupportActionBar().setTitle("Marvel Movies");
                db = new DataAdapter(this, "MARVEL");
                db.createDatabase();
                db.open();
                movies = db.getData();
                db.close();
                break;
            case 1:
                getSupportActionBar().setTitle("Great Alternatives");
                movies.add(new Movies("The Dark Knight", "2008", "With the help of allies Lt." +
                        " Jim Gordon and DA Harvey Dent, Batman has been able to keep a tight lid on" +
                        " crime in Gotham City. But when a vile young criminal calling himself the Joker" +
                        " suddenly throws the town into chaos, the caped Crusader begins to tread a fine" +
                        " line between heroism and vigilantism.", R.drawable.batman));

                movies.add(new Movies("Green Lantern", "2011", "Sworn to preserve intergalactic order, the Green Lantern" +
                        " Corps has existed for centuries. Its newest recruit, Hal Jordan," +
                        " is the first human to join the ranks. The Green Lanterns have" +
                        " little regard for humans, who have thus far been unable to harness" +
                        " the powers of the ring each member wears. But Jordan, a gifted and" +
                        " cocky test pilot, may be the corps' only hope when a new enemy" +
                        " called Parallax threatens the universal balance of power.", R.drawable.greenlantern));

                movies.add(new Movies("Man of Steel", "2013", "With the imminent destruction of Krypton, their home planet, Jor-El" +
                        " and his wife seek to preserve their race by sending their infant son to" +
                        " Earth. The child's spacecraft lands at the farm of Jonathan and Martha" +
                        " Kent, who name him Clark and raise him as their own son. Though his" +
                        " extraordinary abilities have led to the adult Clark living on the fringe" +
                        " of society, he finds he must become a hero to save those he loves from a dire threat.", R.drawable.superman));

                movies.add(new Movies("Daredevil (Netflix)", "2015", "Blinded in an accident as a child," +
                        " Murdock uses his heightened senses as Daredevil to fight crime on the streets of" +
                        " New York after the sun goes down. While Murdock's day job requires him to" +
                        " believe in the criminal justice system, his alter ego does not follow suit," +
                        " leading him to take the law into his own hands to protect his Hell's Kitchen" +
                        " neighborhood and the surrounding communities.", R.drawable.dd));

                movies.add(new Movies("Wonder Woman", "2017", "Before she was Wonder Woman, she was Diana, princess of the" +
                        " Amazons, trained to be an unconquerable warrior. Raised on a" +
                        " sheltered island paradise, Diana meets an American pilot" +
                        " who tells her about the massive conflict that's raging in the" +
                        " outside world. Convinced that she can stop the threat, Diana" +
                        " leaves her home for the first time. Fighting alongside men in a" +
                        " war to end all wars, she finally discovers her full powers and" +
                        " true destiny.", R.drawable.wonderwoman));
                break;
            case 2:
                getSupportActionBar().setTitle("All Movies");
                db = new DataAdapter(this, "MARVEL");
                db.createDatabase();
                db.open();
                movies = db.getData();
                db.close();
                movies.add(new Movies("The Dark Knight", "2008", "With the help of allies Lt." +
                        " Jim Gordon and DA Harvey Dent, Batman has been able to keep a tight lid on" +
                        " crime in Gotham City. But when a vile young criminal calling himself the Joker" +
                        " suddenly throws the town into chaos, the caped Crusader begins to tread a fine" +
                        " line between heroism and vigilantism.", R.drawable.batman));

                movies.add(new Movies("Green Lantern", "2011", "Sworn to preserve intergalactic order, the Green Lantern" +
                        " Corps has existed for centuries. Its newest recruit, Hal Jordan," +
                        " is the first human to join the ranks. The Green Lanterns have" +
                        " little regard for humans, who have thus far been unable to harness" +
                        " the powers of the ring each member wears. But Jordan, a gifted and" +
                        " cocky test pilot, may be the corps' only hope when a new enemy" +
                        " called Parallax threatens the universal balance of power.", R.drawable.greenlantern));

                movies.add(new Movies("Man of Steel", "2013", "With the imminent destruction of Krypton, their home planet, Jor-El" +
                        " and his wife seek to preserve their race by sending their infant son to" +
                        " Earth. The child's spacecraft lands at the farm of Jonathan and Martha" +
                        " Kent, who name him Clark and raise him as their own son. Though his" +
                        " extraordinary abilities have led to the adult Clark living on the fringe" +
                        " of society, he finds he must become a hero to save those he loves from a dire threat.", R.drawable.superman));

                movies.add(new Movies("Daredevil (Netflix)", "2015", "Blinded in an accident as a child," +
                        " Murdock uses his heightened senses as Daredevil to fight crime on the streets of" +
                        " New York after the sun goes down. While Murdock's day job requires him to" +
                        " believe in the criminal justice system, his alter ego does not follow suit," +
                        " leading him to take the law into his own hands to protect his Hell's Kitchen" +
                        " neighborhood and the surrounding communities.", R.drawable.dd));

                movies.add(new Movies("Wonder Woman", "2017", "Before she was Wonder Woman, she was Diana, princess of the" +
                        " Amazons, trained to be an unconquerable warrior. Raised on a" +
                        " sheltered island paradise, Diana meets an American pilot" +
                        " who tells her about the massive conflict that's raging in the" +
                        " outside world. Convinced that she can stop the threat, Diana" +
                        " leaves her home for the first time. Fighting alongside men in a" +
                        " war to end all wars, she finally discovers her full powers and" +
                        " true destiny.", R.drawable.wonderwoman));
                break;
        }
        initializeAdapter();
    }

    //displays content in activity
    private void initializeAdapter(){
        RVAdapter adapter = new RVAdapter(movies);
        rv.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu and adds items to the action bar
        getMenuInflater().inflate(R.menu.menu_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch(item.getItemId())
        {
            case R.id.Marvel:
                current = 0;
                break;
            case R.id.otherRecs:
                current = 1;
                break;
            case R.id.all:
                current = 2;

                break;
        }
        initializeData();
        return super.onOptionsItemSelected(item);
    }

    //clears the recycle view before repopulating with new data
    public void clear()
    {
        rv.removeAllViewsInLayout();
    }

    @Override
    protected void onSaveInstanceState (Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("Value", current);
    }

}
