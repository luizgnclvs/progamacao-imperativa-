public class Employee {

    public static int count = 1;

    private int id;
    private String name;
    private int post;

    public Employee () {

    }

    public Employee (String name, int post) {
        this.id = count;
        this.name = name;
        this.post = post;

        count++;
    }

    public void setName (String name) {
        this.name = name;
    }

    public void setPost (int post) {
        this.post = post;
    }

    public int getId () {
        return id;
    }

    public String getName () {
        return name;
    }

    public int getPost () {
        return post;
    }

    public String getPostName () {
        for (int i = 0; i < Post.postList.length; i++) {
            if (this.post ==  Post.postList[i].getId()) {
                return Post.postList[i].getDescrpition();
            }
        }

        return "";
    }

    public double getSalary () {
        for (int i = 0; i < Post.postList.length; i++) {
            if (this.post ==  Post.postList[i].getId()) {
                return Post.postList[i].getPayment();
            }
        }

        return -1;
    }

    public String toString () {
        return "Funcionário: " + name + " (ID: " + id + ") - Cargo: " + this.getPostName() + ", Salário: R$ " + this.getSalary();
    }
}