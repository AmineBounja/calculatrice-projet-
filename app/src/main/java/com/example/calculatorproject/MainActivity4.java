package com.example.calculatorproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class MainActivity4 extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        drawerLayout=findViewById(R.id.drawer_layout);
        navigationView=findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        toolbar=findViewById(R.id.toolbar);
        Menu menu=navigationView.getMenu();
        MenuItem logoutItem = menu.findItem(R.id.nav_logout);
        if (logoutItem != null) {
            logoutItem.setVisible(false);
        }
        navigationView.bringToFront();
        toggle= new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_home);
        }
    @Override
    public void onBackPressed(){
        //fermer le menu si je clique sur le bouton return
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
        }
    }
@Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem){
    if (menuItem.getItemId() == R.id.nav_home) {
        Intent intent = new Intent(MainActivity4.this,MainActivity2.class);
        startActivity(intent);
    } else if (menuItem.getItemId() == R.id.nav_calc) {
        Intent intent = new Intent(MainActivity4.this, MainActivity3.class);
        startActivity(intent);
    } else if (menuItem.getItemId() == R.id.nav_share) {
        Toast.makeText(this, "Share", Toast.LENGTH_LONG).show();
    } else if (menuItem.getItemId()==R.id.nav_logout||menuItem.getItemId()==R.id.nav_logout2) {
        Intent intent = new Intent(MainActivity4.this,MainActivity.class);
        startActivity(intent);

    }

    drawerLayout.closeDrawer(GravityCompat.START);
        return true;

}


}
