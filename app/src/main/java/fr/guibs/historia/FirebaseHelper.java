package fr.guibs.historia;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class FirebaseHelper {

    private DatabaseReference databaseReference;

    public FirebaseHelper() {
        // Obtenir la référence à la base de données
        databaseReference = FirebaseDatabase.getInstance().getReference("facts");
    }

    public interface DataStatus {
        void DataIsLoaded(String fact);
        void DataIsNotLoaded();
    }

    public void getRandomFact(final DataStatus dataStatus) {
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // Compter le nombre de faits
                long count = dataSnapshot.getChildrenCount();
                // Choisir un index aléatoire
                int index = (int) (Math.random() * count);
                // Récupérer le fait à l'index choisi
                String fact = null;
                int i = 0;
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    if (i == index) {
                        fact = snapshot.getValue(String.class);
                        break;
                    }
                    i++;
                }
                if (fact != null) {
                    dataStatus.DataIsLoaded(fact);
                } else {
                    dataStatus.DataIsNotLoaded();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                dataStatus.DataIsNotLoaded();
            }
        });
    }
}
