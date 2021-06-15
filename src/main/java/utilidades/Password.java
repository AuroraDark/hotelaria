package utilidades;

import org.jasypt.util.password.BasicPasswordEncryptor;

//Encripta a senha pra colocar no BD, se vc quiser colocar direto no bd
public class Password {

    public static void main(String[] args) {
        BasicPasswordEncryptor passwordEncryptor = new BasicPasswordEncryptor();
        String senhaCriptografada = passwordEncryptor.encryptPassword("suasenhaaqui");
        System.out.println(senhaCriptografada);
    }
}
