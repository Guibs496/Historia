package fr.guibs.historia;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView factTextView;
    private Button newFactButton;
    private Animation fadeIn;
    private FirebaseHelper firebaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialisation des vues
        factTextView = findViewById(R.id.factTextView);
        newFactButton = findViewById(R.id.newFactButton);

        // Initialisation de l'animation
        fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in);

        // Initialisation de FirebaseHelper
        firebaseHelper = new FirebaseHelper();

        // Affiche un fait aléatoire au démarrage
        displayRandomFact();

        // Configure le bouton pour afficher un nouveau fait avec animation
        newFactButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayRandomFact();
            }
        });
    }

    private void displayRandomFact() {
        firebaseHelper.getRandomFact(new FirebaseHelper.DataStatus() {
            @Override
            public void DataIsLoaded(String fact) {
                factTextView.setText(fact);
                factTextView.startAnimation(fadeIn);
            }

            @Override
            public void DataIsNotLoaded() {
                factTextView.setText("Impossible de charger le fait.");
            }
        });
    }
}
