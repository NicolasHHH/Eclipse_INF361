import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class DiffieHellman768 {
	final BigInteger p;
	final BigInteger q;
	final BigInteger g;
	private BigInteger a;
	BigInteger demiCle; // g^a
	private BigInteger cleSecrete; // g^ab
	private byte[] cleSecreteSym;
    private SecretKeySpec cleSecreteAES;

	DiffieHellman768(){
		// ce sont des parametres trop courts, mais c'est juste pour le TP.
		// Oakley primes
		p = new BigInteger("1552518092300708935130918131258481755631334049434514313202351194902966239949102107258669453876591642442910007680288864229150803718918046342632727613031282983744380820890196288509170691316593175367469551763119843371637221007210577919");
		q = new BigInteger("776259046150354467565459065629240877815667024717257156601175597451483119974551053629334726938295821221455003840144432114575401859459023171316363806515641491872190410445098144254585345658296587683734775881559921685818610503605288959");
		g = new BigInteger("2");
		cleSecreteSym = new byte[16];
	}
	public String genereDemiCle() {
		// use SecureRandom
		// https://www.enseignement.polytechnique.fr/informatique/Java/1.8/java/security/SecureRandom.html
		//Random rnd = new Random();
		//a = new BigInteger(767, rnd);
		// 767 bits -> 96 bytes (octets)
		SecureRandom random = new SecureRandom();
	    byte octets[] = new byte[96];
	    random.nextBytes(octets);
	    // clear the most-significant bit (supposed to be a bit of sign)
	    octets[0] &= 03;
	    a = new BigInteger(octets);
	    demiCle = g.modPow(a, p);
	    // il faut une demi-cle en base 64 encodee en String pour pouvoir l'envoyer sur le reseau
	    return Base64.getEncoder().encodeToString(demiCle.toByteArray());
	}
	public void genereCleSecrete(String autreDemiCle) {
		byte[] octets = Base64.getDecoder().decode(autreDemiCle);
		BigInteger ga = new BigInteger(octets);
		genereCleSecrete(ga);
	}
	public void genereCleSecrete(BigInteger autreDemiCle) {
		cleSecrete = autreDemiCle.modPow(a, p);
		// on a maintenant une cle secrete commune de la taille de p
		// calculer une empreinte (hash) pour faire du symetrique ensuite
		// https://howtodoinjava.com/security/java-aes-encryption-example/
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("SHA-1");
			byte[] lCleSecreteSym = md.digest(cleSecrete.toByteArray());
			// on ne garde que 128 bits
			for(int i = 0; i < 16; i++)
				cleSecreteSym[i] = lCleSecreteSym[i]; 
			cleSecreteAES = new SecretKeySpec(cleSecreteSym, "AES");
		} catch (NoSuchAlgorithmException e) {
			System.out.println("Erreur pendant le calcul de la cle secrete partagee de 128 bits");
			e.printStackTrace();
		}
	}
	private boolean testCleSecreteSym(byte[] s) {
		// teste si deux cles secretes sont egales
		if (this.cleSecreteSym.length != s.length)
			return false;
		int i = 0;
		while( i < s.length && this.cleSecreteSym[i] == s[i])
			i ++;
		return ( i >= s.length);
	}
	
	public String chiffrer(String message) {
        Cipher chiffre;
		try {
			chiffre = Cipher.getInstance("AES/ECB/PKCS5Padding");
			chiffre.init(Cipher.ENCRYPT_MODE, cleSecreteAES);
	        byte[] c = chiffre.doFinal(message.getBytes()); // argument optionnel "UTF-8"
	        return Base64.getEncoder().encodeToString(c);
		} catch (Exception e) {
	        System.out.println("Erreur pendant le chiffrement : " + e.toString());
			e.printStackTrace();	
		}
		return null;
	}
	
	public String dechiffrer(String message) {
	try {
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
        cipher.init(Cipher.DECRYPT_MODE, this.cleSecreteAES);
        return new String(cipher.doFinal(Base64.getDecoder().decode(message)));
    } 
    catch (Exception e) 
    {
        System.out.println("Erreur pendant le dechiffrement : " + e.toString());
    }
    return null;
	}
	
	public static void main(String[] args) {
		System.out.println("Test Diffie-Hellman");
		DiffieHellman768 alice = new DiffieHellman768();
		DiffieHellman768 bob = new DiffieHellman768();
		String demiCleAlice = alice.genereDemiCle();
		String demiCleBob = bob.genereDemiCle();
		//alice.genereCleSecrete(bob.demiCle);
		//bob.genereCleSecrete(alice.demiCle);
		alice.genereCleSecrete(demiCleBob);
		bob.genereCleSecrete(demiCleAlice);
		boolean ok = alice.cleSecrete.equals(bob.cleSecrete);
		System.out.println("g^a^b == g^b^a: "+ok);
		boolean ok2 = alice.testCleSecreteSym(bob.cleSecreteSym);
		System.out.println("ok2: "+ok2);
		if (! ok2) {
			System.out.println("alice:");
			for (int i = 0 ; i < alice.cleSecreteSym.length; i++)
				System.out.print(" "+alice.cleSecreteSym[i]);
			System.out.println("\nbob:");
			for (int i = 0 ; i < bob.cleSecreteSym.length; i++)
				System.out.print(" "+bob.cleSecreteSym[i]);
			System.out.println();
		}

		String m1 = "test message alice, avec çéàåùÉÅß"; 
		String m2 = "test message bob, avec çéàåùÉÅß"; 
		String s1a = alice.chiffrer(m1);
		String s1b = bob.chiffrer(m1);
		String s2b = bob.chiffrer(m2);
		System.out.println("s1a == s1b: "+ s1a.equals(s1b));
		System.out.println("s1a: "+s1a);
		System.out.println("s1b: "+s1b);
		String n1 = bob.dechiffrer(s1a);
		String n2 = alice.dechiffrer(s2b);
		System.out.println("n1 == m1: "+ n1.equals(m1));
		System.out.println("n2 == m2: "+ n2.equals(m2));
	}
	
}
