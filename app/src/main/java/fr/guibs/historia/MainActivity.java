package fr.guibs.historia;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    // TODO gérer les faits dans une base ou alors les générée par IA
    private String[] historyFacts = {
            "La Grande Muraille de Chine fait plus de 21 000 km de long.",
            "Jules César a été kidnappé par des pirates quand il était jeune.",
            "Le Titanic a coulé en 1912 lors de son voyage inaugural.",
            "La Peste Noire a tué environ 25 millions de personnes en Europe au XIVe siècle.",
            "Les pyramides d'Égypte ont plus de 4 500 ans.",
            "L'Empire romain a duré plus de 1000 ans.",
            "La Tour Eiffel a été achevée en 1889 pour l'Exposition universelle de Paris.",
            "L'homme a marché sur la Lune pour la première fois en 1969.",
            "La Magna Carta a été signée en 1215, marquant un tournant dans l'histoire des droits.",
            "La Révolution française a débuté en 1789, entraînant la fin de la monarchie absolue en France.",
            "Le premier avion des frères Wright a volé en 1903 à Kitty Hawk.",
            "L'Allemagne a été réunifiée en 1990 après la chute du mur de Berlin.",
            "La Première Guerre mondiale a duré de 1914 à 1918, impliquant des pays du monde entier.",
            "La machine à imprimer de Gutenberg, inventée au XVe siècle, a révolutionné la diffusion des livres.",
            "Le Code d'Hammurabi est l'un des plus anciens ensembles de lois, datant de 1754 avant J.-C.",
            "Les Jeux olympiques modernes ont été relancés en 1896 à Athènes, en Grèce.",
            "La chute de Constantinople en 1453 a marqué la fin de l'Empire byzantin.",
            "La déclaration d'indépendance des États-Unis a été signée en 1776.",
            "L'Empire britannique était le plus vaste empire de l'histoire, couvrant environ 25 % de la superficie terrestre.",
            "L'alphabet latin est utilisé par environ 70 % de la population mondiale.",
            "L'invention de l'ampoule électrique par Thomas Edison en 1879 a révolutionné l'éclairage.",
            "La bibliothèque d'Alexandrie, fondée au IIIe siècle avant J.-C., était un centre de savoir de l'antiquité.",
            "La bataille de Waterloo en 1815 a marqué la fin du règne de Napoléon Bonaparte.",
            "L'Holocauste pendant la Seconde Guerre mondiale a vu l'extermination de six millions de Juifs.",
            "La civilisation mésopotamienne est l'une des plus anciennes au monde, ayant émergé autour de 3500 avant J.-C.",
            "Le Colisée de Rome, achevé en 80 après J.-C., pouvait accueillir jusqu'à 50 000 spectateurs.",
            "Le Code de Justinien, compilé au VIe siècle, est une des bases du droit civil moderne.",
            "Le premier téléphone a été inventé par Alexander Graham Bell en 1876.",
            "Le Canal de Suez, ouvert en 1869, a révolutionné le commerce international.",
            "L'éruption du Vésuve en 79 après J.-C. a enseveli les villes de Pompéi et Herculanum sous la cendre.",
            "La Constitution des États-Unis a été ratifiée en 1788 et est toujours en vigueur aujourd'hui.",
            "Les pyramides de Gizeh sont les seules merveilles du monde antique encore debout.",
            "L'écriture cuneiforme, développée en Mésopotamie vers 3400 avant J.-C., est l'une des premières formes d'écriture.",
            "Le premier voyage autour du monde a été complété par Magellan en 1522.",
            "Le Mont Rushmore, sculpté entre 1927 et 1941, représente quatre présidents américains sur une montagne.",
            "Le réchauffement climatique est en partie dû aux émissions de gaz à effet de serre depuis la révolution industrielle.",
            "Les Mayas ont développé un calendrier complexe et une écriture hiéroglyphique avancée.",
            "L'invention de la photographie par Nicéphore Niépce en 1826 a marqué un tournant dans la documentation visuelle.",
            "La Révolution industrielle a commencé au Royaume-Uni au XVIIIe siècle et s'est répandue dans le monde entier.",
            "Les Vikings ont exploré l'Amérique du Nord avant Christophe Colomb, vers l'an 1000.",
            "La bataille de Stalingrad, en 1942-1943, est souvent considérée comme le tournant de la Seconde Guerre mondiale en Europe.",
            "La première machine à calculer a été inventée par Blaise Pascal en 1642.",
            "La guerre de Cent Ans, qui a duré de 1337 à 1453, a opposé la France et l'Angleterre.",
            "L'Empire Ottoman a existé de 1299 à 1922 et a contrôlé une vaste région de l'Europe, de l'Asie et de l'Afrique.",
            "Les premiers Jeux Olympiques antiques ont eu lieu en 776 avant J.-C. à Olympie, en Grèce.",
            "L'invention du vaccin par Edward Jenner en 1796 a été une avancée majeure en médecine.",
            "Les Incas ont construit un réseau impressionnant de routes dans les Andes, connu sous le nom de Qhapaq Ñan.",
            "Le premier ordinateur électronique, le ENIAC, a été mis en service en 1945.",
            "Le mur de Berlin a été construit en 1961 et a été un symbole de la division de l'Allemagne pendant la Guerre froide.",
            "La France a été le premier pays à adopter le système métrique en 1795.",
            "La célèbre Mona Lisa a été peinte par Léonard de Vinci au début du XVIe siècle.",
            "La dynastie Ming, qui a régné sur la Chine de 1368 à 1644, est connue pour ses contributions à la culture et l'art.",
            "La bataille de Trafalgar en 1805 a vu la victoire de la marine britannique contre la flotte franco-espagnole.",
            "La première femme a reçu le prix Nobel, Marie Curie, en 1903 pour ses travaux sur la radioactivité.",
            "L'Antiquité égyptienne est connue pour ses avancées dans la médecine, les mathématiques et l'architecture.",
            "L'empereur Napoléon Bonaparte a été exilé sur l'île d'Elbe en 1814, avant son retour en France et son exil final à Sainte-Hélène.",
            "La guerre de Sécession aux États-Unis a eu lieu entre 1861 et 1865, et a conduit à l'abolition de l'esclavage.",
            "La civilisation égyptienne a construit des temples et des monuments impressionnants, dont le temple de Karnak.",
            "Le premier vol en avion à moteur a été réalisé par les frères Wright en 1903.",
            "La bataille de Gettysburg, en 1863, est souvent considérée comme le tournant de la guerre de Sécession américaine.",
            "L'invention de la télégraphie électrique par Samuel Morse en 1836 a révolutionné les communications à longue distance.",
            "La découverte de l'Amérique par Christophe Colomb en 1492 a ouvert la voie à l'exploration européenne des Amériques.",
            "L'Empire Russe a existé de 1547 à 1917, et a joué un rôle important dans l'histoire de l'Europe et de l'Asie.",
            "L'ère victorienne en Grande-Bretagne (1837-1901) a été marquée par des changements sociaux, politiques et technologiques importants.",
            "Le Louvre à Paris était à l'origine une forteresse médiévale avant de devenir un musée en 1793.",
            "Le procès de Nuremberg après la Seconde Guerre mondiale a jugé les principaux criminels de guerre nazis.",
            "Les premiers explorateurs européens à atteindre l'Antarctique furent les Norvégiens Roald Amundsen et Robert Falcon Scott au début du XXe siècle.",
            "L'Inquisition espagnole, établie en 1478, visait à maintenir l'orthodoxie catholique en Espagne.",
            "Les civilisations anciennes de l'Inde, telles que la civilisation de l'Indus, ont développé des villes sophistiquées il y a environ 4 000 ans.",
            "La Première Guerre mondiale a introduit des technologies militaires modernes, comme les tanks et les avions de combat.",
            "L'âge d'or de l'Islam (VIIIe au XIIIe siècle) a été marqué par des avancées dans les domaines des sciences, de la médecine et des mathématiques.",
            "L'Empire japonais a été un acteur majeur dans les affaires mondiales pendant la période Meiji (1868-1912).",
            "Le Dr Martin Luther King Jr. a prononcé son célèbre discours 'I Have a Dream' en 1963 lors de la Marche sur Washington pour l'emploi et la liberté.",
            "L'invention de la machine à vapeur par James Watt au XVIIIe siècle a été un catalyseur pour la Révolution industrielle.",
            "La chute de l'Empire romain d'Occident en 476 après J.-C. a marqué la fin de l'Antiquité et le début du Moyen Âge en Europe.",
            "La première femme à être élue au Congrès des États-Unis était Jeannette Rankin en 1916.",
            "L'Antiquité grecque est connue pour ses contributions à la philosophie, la politique et les arts.",
            "L'invention de l'Internet a été un processus complexe impliquant de nombreuses contributions depuis les années 1960.",
            "La dynastie des Ptolémées a régné sur l'Égypte après la mort d'Alexandre le Grand et avant l'arrivée des Romains.",
            "Le mouvement des droits civiques aux États-Unis a lutté pour mettre fin à la ségrégation raciale et obtenir des droits égaux pour les Afro-Américains.",
            "Le Code Napoléon, introduit en 1804, a influencé les systèmes juridiques modernes en Europe et au-delà.",
            "Le plus grand volcan actif du monde est le Mauna Loa à Hawaï, qui s'élève à plus de 4 000 mètres au-dessus du niveau de la mer.",
            "La Révolution Haïtienne (1791-1804) a été la première révolte d'esclaves réussie qui a conduit à la création d'une nation indépendante.",
            "Les premières civilisations d'Amérique du Sud, comme les Incas et les Aztèques, ont développé des cultures sophistiquées avant l'arrivée des Européens.",
            "L'Empire espagnol a dominé de vastes territoires en Amérique latine et dans le Pacifique au XVIe siècle.",
            "Le Parti communiste chinois a pris le pouvoir en 1949 après une longue guerre civile et a fondé la République populaire de Chine.",
            "L'un des plus grands penseurs de l'histoire, Socrate, a été condamné à mort pour avoir prétendument corrompu la jeunesse d'Athènes au Ve siècle avant J.-C.",
            "Les Égyptiens anciens utilisaient des hiéroglyphes pour écrire des textes religieux, administratifs et littéraires.",
            "L'Alliance atlantique, ou OTAN, a été créée en 1949 pour assurer une défense collective contre les menaces extérieures.",
            "L'ère de la Renaissance, qui a commencé au XIVe siècle en Italie, a marqué une explosion de la créativité et des découvertes dans l'art et la science.",
            "Les Mayas ont construit des pyramides et des observatoires astronomiques impressionnants dans leur civilisation précolombienne.",
            "La guerre de Vietnam a eu lieu de 1955 à 1975, avec des implications majeures pour la politique internationale et la société américaine.",
            "Les Romains ont construit un réseau de routes qui couvraient des milliers de kilomètres à travers leur empire, facilitant les déplacements et le commerce.",
            "L'invention du papier par les Chinois au IIe siècle avant J.-C. a révolutionné la communication et la documentation.",
            "L'Empire romain d'Orient, ou Empire byzantin, a survécu pendant près de 1 000 ans après la chute de l'Empire romain d'Occident.",
            "L'Institut Pasteur, fondé en 1887 par Louis Pasteur, est un centre de recherche renommé en microbiologie et en vaccinologie.",
            "Le mouvement de décolonisation a conduit à l'indépendance de nombreux pays africains et asiatiques après la Seconde Guerre mondiale.",
            "Les Inuits, habitants des régions arctiques, ont développé des techniques uniques pour survivre dans des conditions extrêmes.",
            "Le Moyen Âge a été marqué par la construction de nombreuses cathédrales gothiques, connues pour leurs vitraux et leurs voûtes en ogive.",
            "La guerre des roses en Angleterre (1455-1487) a été une série de conflits dynastiques pour le trône d'Angleterre.",
            "Les civilisations de la vallée de l'Indus, qui fleurirent il y a environ 4 500 ans, avaient des villes bien planifiées et des systèmes d'assainissement avancés.",
            "La première mission spatiale habitée, Vostok 1, a été lancée par l'Union soviétique en 1961, avec Youri Gagarine comme premier cosmonaute.",
            "L'ère victorienne a vu l'essor de l'industrialisation, des inventions et des réformes sociales en Grande-Bretagne.",
            "Le Mont Saint-Michel en France a servi de forteresse, abbaye et lieu de pèlerinage au cours des siècles.",
            "Les Mongols, sous Gengis Khan, ont créé l'un des plus grands empires terrestres de l'histoire au XIIIe siècle.",
            "La première femme à obtenir un diplôme universitaire en France était Marie Curie, qui a également remporté deux prix Nobel.",
            "Les États-Unis ont acheté l'Alaska à la Russie en 1867 pour 7,2 millions de dollars, un achat qui a été surnommé 'le mauvais achat' jusqu'à ce que des ressources soient découvertes.",
            "La guerre d'Indépendance des États-Unis a été influencée par des idées d'égalité et de liberté issues des Lumières.",
            "Les pyramides de Teotihuacan au Mexique sont connues pour leurs grandes pyramides du Soleil et de la Lune.",
            "La première machine à laver moderne a été inventée au XIXe siècle, simplifiant la tâche ménagère.",
            "Les Mayas ont développé un calendrier complexe basé sur des cycles solaires et lunaires précis.",
            "La chute de l'Empire Aztec en 1521 a été marquée par la conquête espagnole dirigée par Hernán Cortés.",
            "Le Protocole de Kyoto, signé en 1997, visait à réduire les émissions de gaz à effet de serre à l'échelle mondiale.",
            "L'Armistice de la Première Guerre mondiale a été signé le 11 novembre 1918, mettant fin aux combats sur le front occidental.",
            "La première dynastie de la Chine impériale, la dynastie Qin, a été fondée en 221 avant J.-C. par Qin Shi Huang.",
            "Le Royaume de Kush, situé au sud de l'Égypte ancienne, a eu une influence importante sur la région pendant plusieurs siècles.",
            "Les civilisations de la Grèce antique ont jeté les bases de la démocratie, des sciences et des arts.",
            "Le mouvement féministe du XXe siècle a lutté pour des droits égaux et l'émancipation des femmes dans de nombreux pays.",
            "La Révolution industrielle a introduit des machines à vapeur, des usines et des changements radicaux dans la société.",
            "Les Romains ont construit l'aqueduc de Pont du Gard en France pour acheminer l'eau à la ville de Nîmes.",
            "La première émission de télévision en direct a eu lieu en 1936, marquant le début de la télévision moderne.",
            "Les civilisations anciennes, comme celle des Hittites, ont contribué à l'écriture, au droit et à la culture en Anatolie.",
            "L'Empire Perse, sous Darius Ier, a mis en place un système administratif complexe et un réseau de routes pour l'empire.",
            "L'Empire Romain a connu une période de paix relative appelée la Pax Romana, qui a duré environ 200 ans.",
            "Les Égyptiens ont inventé le papyrus, un matériau d'écriture utilisé dans l'Antiquité pour enregistrer des documents.",
            "L'invention du télégraphe a permis la communication instantanée sur de longues distances pour la première fois.",
            "Le Code Napoléon a influencé les systèmes juridiques dans de nombreux pays au-delà de la France.",
            "Le Grand Incendie de Londres en 1666 a détruit une grande partie de la ville, mais a permis de la reconstruire avec des plans plus modernes.",
            "Les civilisations précolombiennes, comme les Olmèques, ont développé des traditions artistiques et architecturales uniques.",
            "La Première Guerre mondiale a été suivie par la signature du traité de Versailles en 1919, qui a redéfini les frontières européennes.",
            "La découverte des Amériques par Christophe Colomb en 1492 a marqué le début de l'exploration européenne du Nouveau Monde.",
            "Les civilisations anciennes de Mésopotamie ont inventé les premiers systèmes d'écriture connus sous le nom de cunéiforme.",
            "La Première dynastie de la Chine impériale, les Qin, a été fondée par Qin Shi Huang, le premier empereur de Chine.",
            "L'Empire Ottoman a eu une influence significative sur l'Europe et le Moyen-Orient pendant plusieurs siècles.",
            "L'invention du microscope par Antonie van Leeuwenhoek au XVIIe siècle a révolutionné la biologie et la médecine.",
            "Les Incas ont développé un réseau complexe de routes et de ponts dans les Andes pour relier leur vaste empire.",
            "La Révolution scientifique du XVIIe siècle a introduit des méthodes expérimentales et des découvertes majeures en physique et en astronomie.",
            "La signature du traité de Tordesillas en 1494 a divisé le Nouveau Monde entre l'Espagne et le Portugal.",
            "L'ère des grandes découvertes, du XVe au XVIIe siècle, a vu l'exploration et la colonisation de nouvelles régions du monde.",
            "Les Romains ont construit des bains publics complexes et des systèmes de chauffage pour améliorer la vie urbaine.",
            "Le Pacte de Varsovie, signé en 1955, était une alliance militaire des pays communistes dirigée par l'Union soviétique.",
            "Les dynasties chinoises, telles que les Tang et les Song, ont fait avancer les arts, la science et la technologie.",
            "L'histoire des voyages dans l'espace a commencé avec le lancement du Spoutnik en 1957, le premier satellite artificiel.",
            "La construction du Panthéon à Rome a été un exploit d'ingénierie avec sa grande coupole en béton.",
            "Le Chemin de fer transcontinental américain a été achevé en 1869, reliant les côtes est et ouest des États-Unis.",
            "Les civilisations anciennes de l'Inde ont laissé des contributions durables dans les domaines des mathématiques et de l'astronomie.",
            "L'Empire espagnol a dominé de vastes territoires en Amérique latine et dans le Pacifique au XVIe siècle.",
            "Les Grecs anciens ont inventé le concept de la démocratie directe et ont contribué à la philosophie et aux arts.",
            "La Première Guerre mondiale a introduit des technologies militaires modernes, comme les tanks et les avions de combat.",
            "Les premiers jeux olympiques antiques ont eu lieu en 776 avant J.-C. à Olympie, en Grèce.",
            "La Révolution industrielle a transformé les économies et les sociétés avec l'introduction de nouvelles technologies et d'industries.",
            "Les civilisations précolombiennes, comme les Aztèques et les Mayas, ont développé des sociétés avancées en Amérique centrale et du Sud.",
            "La découverte de la pénicilline par Alexander Fleming en 1928 a révolutionné le traitement des infections bactériennes.",
            "La guerre de Sécession américaine a été un conflit crucial qui a mis fin à l'esclavage aux États-Unis.",
            "La dynastie Ming en Chine a été marquée par des réalisations artistiques et architecturales, dont la Cité interdite.",
            "Le naufrage du Lusitania en 1915 a été un événement clé qui a contribué à l'entrée des États-Unis dans la Première Guerre mondiale.",
            "L'Empire romain d'Orient, ou Empire byzantin, a survécu pendant près de 1 000 ans après la chute de l'Empire romain d'Occident.",
            "La Révolution américaine a conduit à la création des États-Unis d'Amérique et à l'adoption de la Constitution en 1787.",
            "Les civilisations anciennes, comme les Égyptiens et les Babyloniens, ont laissé des contributions durables dans les domaines des mathématiques et de l'astronomie."
    };

    private TextView factTextView;
    private Button newFactButton;
    private Random random;
    private Animation fadeIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        factTextView = findViewById(R.id.factTextView);
        newFactButton = findViewById(R.id.newFactButton);
        random = new Random();

        // Charge l'animation une fois
        fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in);

        // Affiche un fait aléatoire au démarrage
        displayRandomFact();

        // Configure le bouton pour afficher un nouveau fait avec animation
        newFactButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                factTextView.startAnimation(fadeIn);
                displayRandomFact();
            }
        });
    }

    private void displayRandomFact() {
        int index = random.nextInt(historyFacts.length);
        factTextView.setText(historyFacts[index]);
    }
}
