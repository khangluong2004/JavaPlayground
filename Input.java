package playground;
import java.util.Scanner;


class Input{
    public static void main(String[] args){
        System.out.println("Age:");
        Scanner age_input = new Scanner(System.in, "utf8");
        int age = age_input.nextInt();

        // Note that the first .nextLine read the empty part at the end
        String other_string = age_input.nextLine();
        other_string = age_input.nextLine();
        System.out.println(age);
        System.out.println(other_string);

        age_input.close();
    }
}