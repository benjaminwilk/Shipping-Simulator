package src.main.java;

import src.main.java.Player.*;

public class MenuDisplays{

	final static private String[] goodsDisplayMenu = {"Load / Unload Containers", "Step Ashore" ,"Depart Port"};

	private static final String[] portNames = {"Long Beach", "Hong Kong", "Sydney"};
	private static final String[] availablePorts1 = {"LA", "SY", "HK"};
	/*** Long Beach --> Sydney --> Hong Kong ***/
	//private static final String[] availablePorts2 = {"VC", "TK", "LM"};
	/*** Vancouver --> Tokyo --> Lima ***/
	private static final double[] portLatitude = {33.754185, -33.858333,  22.287753};
	private static final double[] portLongitude = {-118.216458, 151.233333, 114.173619};

	private static final String[] containerMenu = {"Check Container Prices", "Display Loaded Containers", "Load Containers", "Unload Containers", "Go Back"};
	
	private static final String[] shoreOptionMenu = {"Check Weather Report", "Manage Crewmembers", "Check Ship Status", "Refuel Ship", "Check Port Prices", "Go Back"};
	
	private static final String[] weatherOptions = {"Sunny", "Partly Cloudy", "Partly Sunny", "Cloudy", "Light Rain", "Rain", "Heavy Rain", "Light Snow", "Snow", "Heavy Snow"};
	
	private static final String[] containerTypes = {"Standard Goods", "Volatile Goods", "Vehicles"};
	
	private static final String[] shoreSubMenu = {"Check for Damage", "Refit Storage", "Upgrade Ship", "Go Back"};
	
	private static String[] Countries = {"Afghanistan", "Albania", "Algeria", "American Samoa", "Andorra", "Angola", "Anguilla", "Antigua & Barbuda", "Argentina", "Armenia", "Aruba", "Australia", "Austria", "Azerbaijan", "Bahamas", "Bahrain", "Bangladesh", "Barbados", "Belarus", "Belgium", "Belize", "Benin", "Bermuda", "Bhutan", "Bolivia", "Bosnia & Herzegovina", "Botswana", "Brazil", "British Virgin Islands", "Brunei", "Bulgaria", "Burkina Faso", "Burma", "Burundi", "Cambodia", "Cameroon", "Canada", "Cape Verde", "Cayman Islands", "Central African Republic", "Chad", "Chile", "China", "Colombia", "Comoros", "Dem. Rep. Congo", "Repub. of the Congo", "Cook Islands", "Costa Rica", "Cote d'Ivoire", "Croatia", "Cuba", "Cyprus", "Czech Republic", "Denmark", "Djibouti", "Dominica", "Dominican Republic", "East Timor", "Ecuador", "Egypt", "El Salvador", "Equatorial Guinea", "Eritrea", "Estonia", "Ethiopia", "Faroe Islands", "Fiji", "Finland", "France", "French Guiana", "French Polynesia", "Gabon", "The Gambia", "Gaza Strip", "Georgia", "Germany", "Ghana", "Gibraltar", "Greece", "Greenland", "Grenada", "Guadeloupe", "Guam", "Guatemala", "Guernsey", "Guinea", "Guinea-Bissau", "Guyana", "Haiti", "Honduras", "Hong Kong", "Hungary", "Iceland", "India", "Indonesia", "Iran", "Iraq", "Ireland", "Isle of Man", "Israel", "Italy", "Jamaica", "Japan", "Jersey", "Jordan", "Kazakhstan", "Kenya", "Kiribati", "North Korea", "South Korea", "Kuwait", "Kyrgyzstan", "Laos", "Latvia", "Lebanon", "Lesotho", "Liberia", "Libya", "Liechtenstein", "Lithuania", "Luxembourg", "Macau", "Macedonia", "Madagascar", "Malawi", "Malaysia", "Maldives", "Mali", "Malta", "Marshall Islands", "Martinique", "Mauritania", "Mauritius", "Mayotte", "Mexico", "Federated States of Micronesia", "Moldova", "Monaco", "Mongolia", "Montserrat", "Morocco", "Mozambique", "Namibia", "Nauru", "Nepal", "Netherlands", "Netherlands Antilles", "New Caledonia", "New Zealand", "Nicaragua", "Niger", "Nigeria", "N. Mariana Islands", "Norway", "Oman", "Pakistan", "Palau", "Panama", "Papua New Guinea", "Paraguay", "Peru", "Philippines", "Poland", "Portugal", "Puerto Rico", "Qatar", "Reunion", "Romania", "Russia", "Rwanda", "Saint Helena", "Saint Kitts & Nevis", "Saint Lucia", "St Pierre & Miquelon", "Saint Vincent and the Grenadines", "Samoa", "San Marino", "Sao Tome & Principe", "Saudi Arabia", "Senegal", "Serbia", "Seychelles", "Sierra Leone", "Singapore", "Slovakia", "Slovenia", "Solomon Islands", "Somalia", "South Africa", "Spain", "Sri Lanka", "Sudan", "Suriname", "Swaziland", "Sweden", "Switzerland", "Syria", "Taiwan", "Tajikistan", "Tanzania", "Thailand", "Togo", "Tonga", "Trinidad & Tobago", "Tunisia", "Turkey", "Turkmenistan", "Turks & Caicos Islands", "Tuvalu", "Uganda", "Ukraine", "United Arab Emirates", "United Kingdom", "United States", "Uruguay", "Uzbekistan", "Vanuatu", "Venezuela", "Vietnam", "Virgin Islands", "Wallis and Futuna", "West Bank", "Western Sahara", "Yemen", "Zambia", "Zimbabwe"};

	private static String[] MaleFirstNames = {"Bale", "Jerome", "Gene", "Wilone", "Wat", "Gael", "Ross","Jud", "Rodney", "Elvis", "Guthrey", "Georgi", "Kelvin", "Bancroft", "Burke", "Rod", "Bryant", "Seymour", "Arvin","Rickie", "Palmer", "Carlos", "Byron", "Shelden", "Zared", "Briggs", "Oswald", "Sigmund", "Dewie","Ervin", "Thaxter","Fonzie", "Temple", "Stephan", "Hercules", "Bondy","Eduardo","Jermaine","Derril","Humphrey", "Meyer", "Bud","Walden","Webster", "Sloan","Rand","Gilles","Vick","Antonius","Park","Bartram","Skip", "Orson", "Shelton", "Archambault", "Frasier", "Neill", "Rowland", "Maximilian", "Nial", "Gradey", "Janis","Quintus", "Lewiss", "Caddric","Spencer","Ellis", "Morris", "Robert","Leonidas","Teddy", "Thom","Ivar","Conrado","Jere", "Danny","Jonathon","Moshe","Giorgio","Keen","Chance","Giff","Tatum","Frederic","Brandon","Gerik","Rickie","Ainsley","Grantley", "Rodrique"};
 
	private static String[] FemalefirstNames = {"Celestina", "Jodi", "Mirabel", "Darline", "Stacey", "Yelena", "Maribeth", "Shae", "Dyanne", "Ilyse", "Julie", "Crystie", "Anne-marie", "Nannette", "Mellisa", "Kamillah", "Berry", "Cora", "Lorena", "Herve", "Aguie", "Bel", "Hallie", "Gwyneth",  "Clerissa", "Keelby", "Elita", "Deloris", "Tobiah", "Sandra", "Glenda", "Carleen", "Mady", "Robinette","Elora","Sheelagh","Adrianne", "Cordie", "Phelia", "Cele", "Candida", "Stefanie", "Maudie", "Othilia", "Cori", "Emmery", "Adena", "Clo", "Josey", "Corine", "Agnesse", "Pennie", "Karie", "Ebonee", "Caril",  "Alica", "Camilla", "Maura", "Nels", "Stephannie", "Sella", "Tonnie", "Chrotoem", "Juanita", "Chryste", "Trude", "Osmund", "Dulcia",  "Melicent", "Emmy", "Katlin","Giselle", "Dorothea","Britte","Josee","Marjory","Daile","Brittne","Sasha","Rona", "Hertha","Rossy","Hube","Lyn","Sibby","Uri","Natalee","Carlita", "Kirstyn", "Therine", "Taffy", "Kirsti", "Cele", "Lesley", "Maud", "Florina", "Blondie", "Flori", "Fenelia", "Floris", "Patrick", "Tessy", "Maren", "Herrick", "Trixy", "Rochester", "Roda", "Sephira", "Toiboid", "Carley", "Caroljean", "Cathie", "Padraig", "Denna", "Tedi", "Nickie", "Hedda", "Jacquetta", "Burke", "Jocelyne", "Algernon", "Saundra", "Ronnica", "Karon", "Alayne", "Joice", "Brittney", "Harbert", "Jaquenette", "Trina", "Gran", "Marti", "Monro", "Maynard", "Nils", "Alberik", "Cherry", "Charo", "Rosella", "Pacorro", "Lizzie", "Jaimie", "Rosette", "Arlana", "Thorstein", "Abagail", "Hermine", "Holly-anne", "Orlan", "Cyrill", "Clerkclaude", "Rhona", "Jolene", "Pascal", "Devonna", "Wallace", "York", "Darb", "Obadias", "Kaiser", "Townie", "Karlik", "Farleigh", "Malia", "Rona", "Bryon", "Noni", "Pietra", "Konstantine", "Trumann", "Stevena", "Dee dee", "Jules", "Humbert", "Mariele", "Lyell", "Bea", "Kirstin", "Bern", "Inglis", "Ferris", "Zaria", "Gabie", "Iseabal", "Lory", "James", "Mady", "Serene", "Kean", "Tybi", "Jackie", "Dyanne", "Shena", "Tomasina", "Abba", "Charyl", "Ximenes", "Madlen", "Pippa", "Theo", "Pauletta", "Gillie", "Sascha", "Tyrus", "Herrick", "Ulrika", "Isac", "Dorey", "Efren", "Tony", "Jules", "Angelica", "Ambur", "Benito", "Bessy", "Annaliese", "Olivero", "Danyelle", "Juliann", "Corbet", "Terrie", "Erwin", "Laurella", "Gwenny", "Lyda", "Carl", "Minda", "Amerigo", "Aldric", "Standford", "Morris", "Pattie", "Willey", "Gerta", "Grace", "Anny", "Nicky", "Bertrando", "Huberto", "Dulciana", "Brigitte", "Staci", "Renie", "Pennie", "Annabella", "Gus", "Ellerey", "Mada", "Clemmy", "Haze", "Amelie", "Mickey", "Terrel", "Janel", "Gwenneth", "Gawen", "Sandy", "Garwood", "Torey", "Val", "Prent", "Grove", "Charity", "Yuri", "Cass", "Fred", "Annabell", "Blithe", "Georgianne", "Hersh", "Hillyer", "Gilbert", "Jeniffer", "Herschel", "Rafaello", "Candice", "Minnaminnie", "Nancie", "Maurene", "Maxie", "Addi", "Willy", "Marleen", "Roddie", "Ximenez", "Moll", "Gwenore", "Sam", "Munroe", "Elfie", "Shirleen", "Helsa", "Yovonnda", "Harriette", "Irvine", "Claudianus", "Gabie", "Dode", "Beulah", "Bil", "Jelene", "Katine", "Annabel", "Pippy", "Kristi", "Therine", "Mitchel", "Margette", "Melisa", "Angelico", "Ray", "Annalise", "Petey", "Sauncho", "Torrance", "Lamond", "Sharlene", "Peadar", "Anders", "Ossie", "Gillie", "Clim", "Lory", "Abner", "Katinka", "Mala", "Hector", "Filippo", "Sayre", "Luis", "Constantino", "Amelia", "Lita", "Sheena", "Adam", "Raynor", "Joellen", "Alida", "Khalil", "Lem", "Pansy", "Evie", "Reinhold", "Del", "Paolina", "Ossie", "Loy", "Tammie", "Juanita", "Vergil", "Jake", "Chrissie", "Ronni", "Olivette", "Bobby", "Hatti", "Nelly", "Wolf", "Timmi", "Berti", "Marys", "Wolfie", "Elfrida", "Kali", "Northrup", "Karel", "Merle", "Isidor", "Vanessa", "Darelle", "Darcie", "Lorena", "Sabina", "Giff", "Georgi", "Margeaux", "Bendix", "Oswald", "Celesta", "Milty", "Kylynn", "Jeffry", "Dorelle", "Dareen", "Miof mela", "Prue", "Bald", "Nigel", "Ilysa", "Adoree", "Jarred", "Earle", "Maximilien", "Rhianna", "Adelaida", "Joyan", "Marlin", "Lynnet", "Ricardo", "Mill", "Lanny", "Toinette", "Perry", "Felike", "Abraham", "Elonore", "Mackenzie", "Pammy", "Jules", "Minda", "Modestine", "Albertina", "Jannelle", "Joella", "Jeffry", "Webster", "Ignacius", "Stanleigh", "Ardeen", "Cynthy", "Sandye", "Braden", "Morgen", "Mady", "Andrej", "Roselia", "Garey", "Jacky", "Cthrine", "Zaneta", "Tova", "Modesta", "Alvy", "Delmar", "Shina", "Emily", "Andris", "Jan", "Iseabal", "Harlin", "Tuckie", "Julianna", "Ingamar", "Paolina", "Raul", "Clement", "Leona", "Ado", "Orville", "Dorine", "Merna", "Benedikt", "Jillian", "Madelene", "Durant", "Obadias", "Kaylee", "Maddy", "Hermine", "Mathe", "Min", "Daryn", "Othelia", "Sargent", "Zachery", "Janek", "Nickola", "Geoffrey", "Timofei", "Bayard", "Siward", "Saleem", "Emlynn", "Esme", "Valentina", "Sher", "Mikol", "Joana", "Callie", "Prescott", "Gaye", "Benedick", "Merle", "Issiah", "Yolande", "Quinlan", "Felisha", "Shaw", "Shari", "Maria", "Mahmud", "Chrisy", "Farris", "Peg", "Ag", "Randall", "Ardella", "Jaymee", "Joly", "Drew", "Cleo", "Kennith", "Elisha", "Peria", "Nikkie", "Fionna", "Valentine", "Lianne", "Wye", "Orbadiah", "Ev", "Tedie", "Graig", "Doralin", "Constantine", "Lynna", "Sandra", "Pam", "Guss", "Normy", "Fairfax", "Carri", "Gaspard", "Ring", "Karen", "Galvan", "Charles", "Kris", "Wainwright", "Timofei", "Rickie", "Pace", "Tracy", "Nikolia", "Carmelle", "Adriena", "Thomasin", "Catlee", "Patrizio", "Buck", "Hesther", "Lexis", "Kiersten", "Edyth", "Randy", "Alain", "Delcina", "Tally", "Inger", "Tamas", "Abbie", "Shelton", "Nancy", "Geri", "Sophia", "Guillermo", "Brant", "Enrico", "Zacherie", "Merwin", "Saloma", "Giorgi", "Egon", "Friedrich", "Noellyn", "Court", "Pembroke", "Auberta", "Pooh", "Rosalyn", "Hymie", "Leela", "Creigh", "Timofei", "Jere", "Candida", "Isobel", "Prinz", "Artemis", "Huntley", "Ronica", "Mara", "Aylmer", "Alvie", "Glyn", "Kathe", "Lilyan", "Willie", "Justine", "Lucine", "Haslett", "Eleanora", "Hillyer", "Elisabeth", "Doralyn", "Cynthie", "Wynnie", "Mic", "Livvy", "Lonnard", "Lara", "Maximilien", "Marybeth", "Terencio", "Pascale", "Darrelle", "Annelise", "Dinah", "Filmore", "Cleveland", "Caria", "Luigi", "Korney", "Chancey", "Giustina", "Madeleine", "Ursala", "Marty", "Rolando", "Jere", "Miguel", "Addie", "Carina", "Rhona", "Kimbell", "Edmon", "Dominik", "Mirella", "Claudelle", "Findley", "Waite", "Killy", "Olav", "Stormie", "Sarge", "Anett", "Bobby", "Angel", "Iago", "Vicki", "Analise", "Wendye", "Lannie", "Zahara", "Rafa", "Hagen", "Rosie", "Tilly", "Mervin", "Kendrick", "Sebastien", "Dannie", "Ranee", "Ervin", "Berthe", "Conroy", "Davin", "Gard", "Maryellen", "Clim", "Roz", "Winfield", "Deana", "Ira", "Fredi", "Dudley", "Norrie", "Deborah", "Jemie", "Fidole", "Teddi", "Aurel", "Tymothy", "Hillie", "Debby", "Inger", "Fletch", "Allianora", "Viv", "Nita", "Lonnie", "Miller", "Neile", "Eachelle", "Horace", "Dewie", "Conrade", "Arnoldo", "Valry", "Maggee", "Osbert", "Vina", "Bat", "Misty", "Welby", "Linea", "Edeline", "Manfred", "Agnella", "Danila", "Towny", "Maribelle", "Annabell", "Minor", "Xylia", "Valaria", "Marie-jeanne", "Deena", "Georgy", "Suzi", "Gauthier", "Antonius", "Abeu", "Annette", "Phaedra", "Eimile", "Berny", "Elsa", "Cash", "Bradan", "Korella", "Kara", "Erina", "Sophronia", "Niki", "Teresita", "Stewart", "Justis", "Maury", "Mindy", "Ronica", "Hollyanne", "Belinda", "Christian", "Babara", "Monte", "Glendon", "Porty", "Alena", "Albert", "Warner", "Robenia", "Ferguson", "Nicholas", "Scott", "Halley", "Hollis", "Issiah", "Allard", "Dione", "Ellissa", "Dominik", "Noel", "Sergent", "Alvin", "Cyrillus", "Wallie", "Davy", "William", "Husain", "Zabrina", "Rosemarie", "Auberon", "Dorree", "Beret", "Blinny", "Parrnell", "Jennine", "Kenyon", "Biron", "Chuck", "Winny", "Oren", "Mill", "Isidor", "Niki", "Gavan", "Adriena", "Haywood", "Zak", "Braden", "Karney", "Rheta", "Abbie", "Bryanty", "Leta", "Clea", "Augusta", "Otha", "Aigneis", "Fern", "Hagen", "Desirae", "Alia", "Alyosha", "Forest", "Vasily", "Marney", "Linnea", "Yurik", "Maxwell", "Riccardo", "Meir", "Jacklyn", "Hort", "Eleen", "Leelah", "Tomi", "Mellicent", "Cornela", "Allina", "Koenraad", "Stephan", "Ev", "Ernst", "Merralee", "Ina", "Court", "Raymund", "Kailey", "Kerrin", "Lisa", "Heywood", "Reg", "Maximilian", "Jania", "Tobi", "Jennine", "Hazel", "Briny", "Marshal", "Shoshana", "Nannie", "Mab", "Candis", "Berrie", "Frannie", "Bevin", "Rafa", "Noe", "Mendie", "Vivianne", "Shena", "Stace", "Guilbert", "Amalea", "Taffy", "Rahel", "Graig", "Jdavie", "Fritz", "Eugine", "Gerry",  "Gayle", "Forster","Quill","Kennie","Hoyt","Antony","Garreth","Giacomo","Merv","Vergil", "Rania", "Fairlie", "Georgeanne", "Wandis", "Base", "Star", "Gothart", "Fleur", "Gar", "Alaine", "Guendolen", "Jessa", "Conrado", "Charlean", "Leanor", "Marcelline", "Ammamaria", "Andre", "Kelbee", "Kathlin", "Ardelia", "Diahann", "Lotta", "Diana", "Fiann","Valerye","Maitilde", "Muriel", "Ethelred","Annis","Fanchon","Malynda","Peri", "Goldarina"};

	private static String[] lastNames = {"Dyball", "Antliff", "Hourston", "Escoffier", "Palfery", "Maling", "Elland", "Dufore", "Dyet", "Van den Hof", "Lerwill", "Dumbarton", "Barents", "Colmer", "Fidock", "Culvey", "Lilly", "Strowger", "Matuszynski", "Farncombe", "Copnar", "Sadd", "Gopsell", "Kurth", "Bemand", "D'Alwis", "Boyle", "Aimson", "Hindge", "Philimore", "Flather", "Wilgar", "Deware", "House", "MacPeice", "Chadbourne", "Ivanusyev", "Burkitt", "Josefs", "Kamen", "Levett", "Hallitt", "Greeson", "Chaplyn", "Ducker", "Tomkys", "Mussett", "Greer", "Behneke", "Hynard", "Piotr", "Ebbing", "Dumigan", "Clarke-Williams", "Zannetti", "Ackermann", "Waleworke", "Orwin", "Pepperill", "Volcker", "Tregent", "Bartolomeu", "Farthin", "Daborne", "Baumer", "Tather", "Prazor", "Brantzen", "Batalini", "Farfull", "Fontell", "Wadsworth", "Massimo", "Smithson", "Fidock", "Bagenal", "Batstone", "Chesley", "Schenkel", "Townsend", "Body", "Broad", "Shorie", "Meenan", "Racher", "Wybron", "Dillon", "Ley", "Breckon", "Orpen", "Harvie", "MacGarrity", "Malmar", "Gallop", "Schulze", "Gillyatt", "Adamthwaite", "Delnevo", "Realff", "Goucher", "Siggee", "Lewson", "Bampkin", "Starie", "Jewster", "Nanni", "Lindenfeld", "Sarrell", "Gaspero", "Currall", "Haresnaip", "Dow", "Denington", "Fursse", "Pearn", "Flindall", "Fluger", "Cumine", "Haskett", "Saville", "Thorndale", "L'Homme", "Battaille", "Weekes", "Caudelier", "Causbey", "Abeau", "Gouth", "Malkie", "Tarbett", "Ducarne", "MacEllen", "Huyton", "Hungerford", "Cairns", "Deane", "Gally", "Baitson", "Paik", "Biggen", "Ritelli", "Mottley", "Faulder", "McEvoy", "Ambler", "McPhee", "Theyer", "Norcliff", "Martino", "Ecclesall", "Saywell", "Shelton", "Morritt", "Lonergan", "Rustich", "Adamczyk", "Skiplorne", "Gronous", "Menloe", "Mussetti", "Tinkham", "Kiessel", "Byrde", "Woolfenden", "Verrick", "Tillard", "Slaughter", "Lates", "Schankel", "MacTrustram", "Saltsberg", "Juett", "Bauldry", "Ilymanov", "Conaboy", "Tiffney", "Longfoot", "Guthrie", "Geldert", "Lowndsborough", "Scuse", "Leese", "Gerred", "Moseby", "Premble", "MacCoughen", "Royston", "Wattisham", "Raywood", "Sydenham", "Durak", "Lees", "Goodayle", "Loton", "Goodspeed", "Beadell", "Rosiello", "Salisbury", "Jeannin", "Salvatore", "Tomasz", "Montel", "Lambot", "Trowler", "Trythall", "Rennix", "Crippen", "Wychard", "Rogan", "Veldens", "Blow", "Temlett", "Giurio", "Tanman", "Sheirlaw", "Noble", "MacGaughey", "Futter", "Wey", "Thomazet", "Yewdale", "Jacquet", "Jereatt", "Brandsen", "Fassum", "Sigsworth", "Billo", "Slocomb", "Balkwill", "McGrale", "Klimashevich", "Parfett", "Goodall", "Kalinke", "Rabbage", "Deniscke", "Westman", "Duxbury", "Size", "Pideon", "Hrycek", "Sokell", "Strutley", "Cripwell", "Richel", "Dayce", "Menguy", "Kosiada", "Cormack", "Secker", "Studart", "Finlason", "Sharma", "Linfitt", "Fitzsimon", "Brotherton", "Coenraets", "Huxton", "Esgate", "Selburn", "Lyfield", "Brand-Hardy", "Wyer", "Huddle", "Huster", "Tremblay", "Quilkin", "Copsey", "Stowgill", "Penke", "Bartoszinski", "Denekamp", "Silkston", "Capnor", "Lannin", "Duffill", "Buist", "Vidgen", "Willars", "Vickarman", "Harby", "Stenner", "Mayzes", "Rappport", "Dumphry", "Lahiff", "Chater", "Blything", "Villalta", "Cuesta", "Clingoe", "Kilcoyne", "Filyaev", "Finlow", "Corain", "Ashbolt", "Bedberry", "Maharey", "Girogetti", "North", "Meineking", "Hasnney", "Mulran", "Clapston", "Aleavy", "Mapstone", "Lesper", "O'Crowley", "Edwards", "Dorrity", "Lutton", "Sumner", "Whyteman", "Jack", "Seebert", "Roxby", "Mussard", "Cloke", "Stoile", "Bradie", "Whapham", "Bourget", "Spenley", "Haney", "Probey", "Farquharson", "Doyland", "Doll", "Clissett", "Blazewicz", "Kither", "Jupp", "Awde", "Pietz", "Connealy", "Francie", "Holtom", "Gigg", "Polle", "Sully", "Jolliffe", "Boldt", "Philbrook", "Orhtmann", "Bellworthy", "Smithies", "Mackleden", "Marsters", "Yarnley", "Kubista", "Caiger", "Linneman", "Stollsteiner", "Brian", "McKee", "Todeo", "Rock", "Leppard", "Riddick", "Creaney", "Dreghorn", "Drillingcourt", "Artinstall", "Warder", "Maus", "O'Flannery", "Ivanyushin", "Skirvin", "Hartington", "Kerswill", "Tayspell", "Shory", "Klesel", "Bantham", "Tessington", "Dunkerton", "Fonte", "McCully", "Constable", "Gariff", "Tuther", "Maudsley", "Tomlins", "MacNulty", "Strickett", "Pitford", "Yanshin", "Harrie", "Rattrie", "Berntsson", "Clough", "Leyrroyd", "Steenson", "Marke", "Wragg", "Axelby", "Casero", "Clow", "McAdam", "Delamere", "Ladel", "Libbey", "Pierson", "Boylin", "Tregiddo", "Behne", "Lovat", "Boate", "Wackett", "Postians", "Pawlyn", "Lambird", "Kybert", "Rosoman", "Loveday", "Brookes", "Joynes", "Ketteman", "Isakov", "Dennerly", "Hearon", "Hollebon", "Elcott", "Kilbee", "Beekmann", "Rottenbury", "Cancellor", "Churching", "Garken", "McLeoid", "Henrych", "Cleverly", "De Carteret", "Clubley", "Chartman", "Bickerton", "Arnhold", "Pechold", "Tubb", "Dimitriades", "Everil", "Petrolli", "Golsthorp", "Tinn", "Bernocchi", "Conwell", "Collopy", "Wind", "Trunchion", "Sorrell", "Bumpas", "Loughlin", "Blease", "Biggerdike", "Canlin", "McCuis", "Blackway", "Sharer", "Vlasyuk", "Korneev", "Vedeneev", "Aynold", "Freschini", "Tadlow", "Varlow", "Nellen", "Moresby", "Frayn", "Shervil", "Fawkes", "Goodall", "Vurley", "Laboune", "Chicco", "Pickwell", "Lippett", "Kingescot", "Pippard", "Capstake", "Livesey", "Limpenny", "Adel", "Fahey", "Dods", "Kerss", "Klainer", "Cutler", "Chasmer", "O'Crevy", "Rowter", "Lidbetter", "Milbank", "Joinson", "Dominetti", "Tolossi", "Izkovici", "Hosten", "Sanpere", "Kopman", "Duignan", "Holtum", "Shill", "Hubeaux", "St. Quentin", "Heyball", "Freeborn", "Bails", "Adolf", "Duthie", "Delleschi", "Adanet", "McGauhy", "Bullingham", "Prewer", "Danskine", "Broadnicke", "McLagain", "Rotchell", "Verrell", "Lummus", "Tarbox", "Beazer", "Squibe", "Mortel", "Melland", "Treend", "Ranby", "Hatherley", "Romagosa", "Rayhill", "Brimming", "Searight", "Paulack", "Korlat", "Skeene", "Purry", "MacLleese", "Teather", "McFee", "Kendred", "Bethell", "Jenny", "Reinhart", "Hotchkin", "Talks", "Olivi", "Zoane", "Prowting", "Layzell", "Hebbes", "Courtman", "Constanza", "Adamec", "Appleyard", "De Freitas", "Stillman", "Adamsky", "Channon", "Hember", "Shere", "March", "McGrale", "Darrigoe", "Monro", "Naptin", "Tukely", "Belk", "Forcade", "Downes", "Buckle", "Ortells", "Face", "Matlock", "Pegrum", "Arlet", "Oldcote", "Bengtsson", "Jagielski", "Ryde", "Fetterplace", "Szubert", "Reagan", "Pretor", "Saul", "Buske", "Caudwell", "Masden", "Nappin", "Larroway", "Kimmings", "Androli", "Hutten", "Laidlaw", "Giocannoni", "Saggs", "Willison", "Gumby", "Ownsworth", "Fancutt", "Domingues", "Normaville", "Ivanikhin", "Lorente", "Crossingham", "Barns", "Dearle", "Donovan", "Dell 'Orto", "Quinnelly", "Bellenie", "Kline", "Gorham", "Scatchard", "Ormiston", "Naughton", "Yakebovich", "Hyland", "Clayhill", "Clayworth", "Birkenhead", "Penswick", "Jeckell", "Champkins", "Lamperd", "Ilem", "Disbury", "Ackrill", "Duker", "Geering", "Lafoy", "Southorn", "Dawe", "Boise", "Sonschein", "Feuell", "Lawden", "Benns", "Bowers", "Moxted", "Scapens", "Hounsom", "Cruickshanks", "Letherbury", "Dagnall", "Larvin", "Irlam", "Stannett", "Brockelsby", "O'Doherty", "Kunzelmann", "Pilbeam", "Rallings", "Beldan", "Dabes", "Custy", "Bumphrey", "Beall", "Jeeves", "Kempton", "Lebell", "Bonny", "Fawssett", "Andreu", "Emma", "Threadgould", "Manchester", "Fright", "Flury", "Calderhead", "Grimmer", "Wein", "Lindley", "Lowton", "Winsley", "MacCambridge", "Barhams", "Culver", "Mounfield", "Doring", "Roocroft", "Pilgram", "Finding", "De Matteis", "McCourt", "Anderson", "Hebbes", "Overstall", "McLaren", "Pavlov", "Margery", "Clapp", "Leslie", "Manders", "Jovey", "Tett", "Chansonnau", "Benasik", "Deabill", "Calven", "Sally", "Edser", "Bauser", "Rawne", "Hunnawill", "Rubery", "Filchakov", "Exer", "Topaz", "Spearman", "Pane", "Feldman", "Bernadon", "Vinas", "MacAlester", "Eddis", "Mears", "Bryce", "Chotty", "Rilton", "Azam", "Hele", "Samme", "Proven", "Adamkiewicz", "Ramshaw", "Whitebrook", "Garling", "Houlaghan", "Maben", "Fewlass", "deKnevet", "Hymans", "D'Avaux", "Hatwells", "Beaman", "Atherton", "McNally", "Pettican", "Glanvill", "Aimable", "Roper", "Labrow", "MacVicar", "Collibear", "Donnelly", "Otteridge", "Pheby", "Waumsley", "Rothwell", "Thornebarrow", "Beisley", "Poor", "De Souza", "MacMorland", "Elletson", "Barstow", "Agostini", "Kemitt", "Melbourn", "Bedwell", "Pellamont", "Antat", "Mitchell", "Kubas", "Plowman", "Briand", "Frowen", "Gleadhall", "Boolsen", "Fassbindler", "Robertet", "Pellingar", "Donisi", "Lawrie", "Larmour", "Ecclesall", "Burthom", "Musgrove", "Harkness", "Lumsdaine", "Sigsworth", "Engelbrecht", "Skoyles", "Richen", "Spancock", "Ingledew", "McIlhatton", "O'Cahey", "Petit", "Charrier", "Gouda", "Drinkeld", "Silberschatz", "Legrice", "Gelly", "Kenelin", "Jurgenson", "Ionn", "Wilcot", "Cleobury", "Kopke", "Belson", "Simmons", "Barfford", "Culshaw", "Chatelain", "Pendlebury", "Rosenshine", "Yerrell", "Mitkov", "Baudet", "Elner", "Jimeno", "Caccavale", "Tomley", "Woodroof", "Spatarul", "Grayer", "Matthews", "Orniz", "Alforde", "McGaraghan", "Lambert-Ciorwyn", "Marshman", "Bushe", "Fitzsymonds", "Slides", "Oglesbee", "Ivakhnov", "Doctor", "Tejero", "Renwick", "Laddle", "Bleier", "Barkworth", "Hamson", "Sincock", "Wheildon", "Janous", "Drynan", "Smullen", "Dust", "Aikin", "Wride", "Giacopelo", "Kelwick", "Siege", "Keedwell", "Sanja", "Spat", "Carryer", "House", "Gumbrell", "Linnard", "Gosby", "McChruiter", "Aronstam", "MacMaykin", "Birts", "Jameson", "Seilmann", "Longhorne", "Vynoll", "Zamora", "Blanc", "Brantzen", "Biscomb", "Lambrick", "Elegood", "Klassmann", "Timmes", "Checcucci", "Cossans", "O'Glassane", "Pyburn", "Spurryer", "Sivills", "Erb", "Dowman", "Mendenhall", "Mattessen", "Costen", "Piletic", "Mallord", "Bodicam", "Anster", "Amar", "Wurz", "Lamberth", "Ilchenko", "Ruprechter", "Fassbender", "Bassil", "Tudbald", "Trobridge", "Marchiso", "Towns", "Loveland", "Sheehan", "Yearby", "Nathon", "Slisby", "Hasard", "Aimable", "Pedersen", "Irvin", "Allflatt", "Eagers", "Scheffler", "Dunford", "Pingston", "Pougher", "Inkpen", "Yoxall", "Pettitt", "Salsbury", "Pickersail", "Drinkale", "Waterstone", "Lambourn", "Eyer", "Larratt", "Ethridge", "Whittock", "Cluelow", "Onyon", "Bowbrick", "Dobsons", "Dmitriev", "Causbey", "Finch", "Heaps", "Fleischmann", "Tompkin", "Diddams", "Dofty", "Dickings", "Stranks", "Buxton", "Quadrio", "Rault", "Frantsev", "Pendred", "Ridgers", "Jakubovitch", "Dellow", "Sewley", "Heliot", "Fairest", "Dedam", "Yelding", "Cawsy", "Mayger", "Shaddock", "Pawlick", "Matic", "Spreull", "Kencott", "Borland", "Swaffer", "Gaudon", "Shine", "Pavese", "Frowde", "Machent", "Irving", "Platfoot", "Escalante", "Cresser", "Porker", "Jeves", "Collaton", "Cosstick", "Pirson", "Sharville", "Berthomieu", "Harmston", "Slator", "Makey", "Pitcaithley", "Deverose", "Tunder", "Florez", "Dettmar", "Buesnel", "Loweth", "Lippitt", "Popham", "Truggian", "Andrivel", "Rourke", "Winterton", "Crean", "Armall", "Penddreth", "Whittock", "Iacapucci", "Stein","Larmett", "Healeas"};

	private static String[] continent = {"Africa", "Europe", "Asia", "North America", "South America", "Oceania"};
	
	private static String[] shipAreas = {"Hull", "Engine", "Exterior", "Loading Area", "Interior", "Ship upgrade"};
	
	private static final String[] hullModifications = {"Zincs", "Propeller", "Hull Integrity"};
	private static final String[] engineModifications = {"New Engine", "Engine maintenance", "new shafts"};
	private static final String[] exteriorModifications = {"Crane Addition"};
	private static final String[] loadingAreaModifications = {"Expand area", ""};
	private static final String[] interiorModifications = {"Better accomodations"};
	
	
	public static String[] GetGoodsMenu(){
		return goodsDisplayMenu;
	}

	public static String GetAvailablePorts(int userChosenValue){
		return "" + availablePorts1[userChosenValue - 1];
	}
	
	public static String GetAvailablePortsNoOffset(int userChosenValue){
		return "" + availablePorts1[userChosenValue];
	}
	
	public static String[] GetAvailablePorts(){
		return availablePorts1;
	}
	
	public static String[] GetContainerMenu(){
		return containerMenu;
	}
	
	public static String[] GetShoreOptionMenu(){
		return shoreOptionMenu;
	}
	
	public static double[] GetPortLatitude(){
		return portLatitude;
	}
	
	public static String GetPortLatitude(int passedValue){
		return "" + portLatitude[passedValue];
	}
	
	public static double[] GetPortLongitude(){
		return portLongitude;
	}
	
	public static String GetPortLongitude(int passedValue){
		return "" + portLongitude[passedValue];
	}
	
	public static int GetWeatherOptionLength(){
		return weatherOptions.length;
	}
	
	public static String[] GetWeatherOptions(){
		return weatherOptions;
	}
	
	public static String GetWeatherOptions(int arrayChoice){
		return weatherOptions[arrayChoice - 1];
	}
	
	public static int GetAvailablePortsSize(){
		return availablePorts1.length;
	}
	
	public static String[] GetShoreSubMenu(){
		return shoreSubMenu;
	}
	
	public static String GetFemaleNames(int passedValue){
		return FemalefirstNames[passedValue];
	}
	
	public static int GetFemaleNameCount(){
		return FemalefirstNames.length;
	}
	
	public static String GetMaleNames(int passedValue){
		return MaleFirstNames[passedValue];
	}
	
	public static int GetMaleNameCount(){
		return MaleFirstNames.length;
	}
	
	public static String GetCountry(int passedValue){
		return Countries[passedValue];
	}
	
	public static int GetCountryCount(){
		return Countries.length;
	}
	
	public static int GetLastNameCount(){
		return lastNames.length;
	}
	
	public static String[] GetPortName(){
		return portNames;
	}
	
	public static String GetPortName(int passedValue){
		return portNames[passedValue];
	}
	
	public static String[] getShipAreas(){
		return shipAreas;
	}
	
	public static String getShipAreas(int passedValue){
		return shipAreas[passedValue];
	}
	
	public static int getShipAreaLength(){
		return shipAreas.length;
	}
	
	public static String GetLastNames(int passedValue){
		return lastNames[passedValue];
	}
	
	public static String[] GetContainerTypes(){
		return containerTypes;
	}
	
}