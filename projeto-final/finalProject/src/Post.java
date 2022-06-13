public class Post {

    private static int count = 1;

    private int id;
    private String description;
    private double payment;

    public static Post [] postList;

    public Post () {
        this.id = count;
        count++;
    }

    public Post (String description, double payment) {
        this.id = count;
        this.description = description;
        this.payment = payment;

        count++;
    }

    public void setDescription (String description) {
        this.description = description;
    }

    public void setPayment (double payment) {
        this.payment = payment;
    }

    public int getId () {
        return id;
    }

    public String getDescrpition () {
        return description;
    }

    public double getPayment () {
        return payment;
    }

     // Parâmetros conforme solicitados pelo Profº
     private static String [] postsNames = new String [] {
        "Analista de Salários",
        "Auxiliar de Contabilidade",
        "Chefe de Cobrança",
        "Chefe de Expedição",
        "Contador",
        "Gerente de Divisão",
        "Escrituário",
        "Faxineiro",
        "Gerente Administrativo",
        "Gerente Comercial",
        "Gerente de Pessoal",
        "Gerente de Treinamento",
        "Gerente Financeiro",
        "Contínuo",
        "Operador de Computador",
        "Programador de Computador",
        "Secretária"
    };

    private static double [] postsSalaries = new double [] {
        1200.00, 800.00, 1500.00, 1700.00, 2000.00, 2600.00, 850.00, 550.00, 2300.00, 1900.00, 1400.00, 950.00, 2200.00, 1000.00, 700.00, 1800.00, 1000.00
    };

    public static void setPostList () {
        postList = new Post [postsNames.length];

        for (int i = 0; i < postList.length; i++) {
            Post.postList[i] = new Post(postsNames[i], postsSalaries[i]);
        }
    }

    public static void printPostList () {
        System.out.println("Código\tCargo\n");
        for (int i = 0; i < Post.postList.length; i++) {
            System.out.printf("%4d\t%s%n", Post.postList[i].getId(), Post.postList[i].getDescrpition());
        }
    }
}