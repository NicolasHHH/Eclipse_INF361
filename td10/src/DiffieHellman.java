import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class DiffieHellman {
	final BigInteger p;
	final BigInteger q;
	final BigInteger g;
	private BigInteger a;
	BigInteger demiCle; // g^a
	private BigInteger cleSecrete; // g^ab
	private byte[] cleSecreteSym;
    private SecretKeySpec cleSecreteAES;

	DiffieHellman(){
		// ce sont des parametres trop courts, mais c'est juste pour le TP.
		/*
        RR = RealField(140)
        p0 = floor(10^37*RR(pi()))
        p0 = p0 - (p0 % 4) + 3
        q0 = (p0-1)//2
        prod_primes = prod(prime_range(10^6))
        ok_q = (gcd(q0, prod_primes) == 1) and q0.is_prime()
        ok_p = ok_q and (gcd(p0, prod_primes) == 1) and p0.is_prime()
        while not (ok_q and ok_p):
            q0 += 2
            p0 += 4
            ok_q = (gcd(q0, prod_primes) == 1) and q0.is_prime()
            ok_p = ok_q and (gcd(p0, prod_primes) == 1) and p0.is_prime()
            if ok_p and ok_q:
                Fp = GF(p0)
                if not (Fp(2)**q0 == 1):
                    ok_p = False ; ok_q = False
                    q0 += 2
                    p0 += 4
        print("p0 = {}\nq0 = {}\ng  = 2".format(p0,q0))
        p0 = 31415926535897932384626433832795083943
		q0 = 15707963267948966192313216916397541971
        g  = 2
		 */
		p = new BigInteger("31415926535897932384626433832795083943");
		q = new BigInteger("15707963267948966192313216916397541971");
		g = new BigInteger("2");
		cleSecreteSym = new byte[16];		
	}
	public String genereDemiCle() {
		// use SecureRandom
		// https://www.enseignement.polytechnique.fr/informatique/Java/1.8/java/security/SecureRandom.html
		//Random rnd = new Random();
		//a = new BigInteger(128, rnd);
		// 128 bits -> 16 bytes (octets)
		SecureRandom random = new SecureRandom();
	    byte octets[] = new byte[16];
	    random.nextBytes(octets);
	    // clear the most-significant bit (supposed to be a bit of sign)
	    //octets[15] &= 03;// non c'est le lsb
	    octets[0] &= 03; // oui c'est le msb
	    a = new BigInteger(octets);
	    //if (! a.equals(a.abs()))
	    	//System.out.println("Error clearing bit of sign did not work");
	    //a = a.abs(); // pour eviter un overflow a cause du signe
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
		//try {
			/*
			MessageDigest md;
			md = MessageDigest.getInstance("SHA-1");
			byte[] lCleSecreteSym = md.digest(cleSecrete.toByteArray());
			// on ne garde que 128 bits
			for(int i = 0; i < 16; i++)
				cleSecreteSym[i] = lCleSecreteSym[i];
			*/
			byte [] cle = cleSecrete.toByteArray();
			for(int i = 0; i < Math.min(cle.length, cleSecreteSym.length); i++)
				cleSecreteSym[i] = cle[i];
			// padding manuel pour eviter erreur cle trop courte AES
			for(int i = cle.length; i < cleSecreteSym.length; i++)
				cleSecreteSym[i] = 00; // prefixer avec 0 pour un byte
			
			cleSecreteAES = new SecretKeySpec(cleSecreteSym, "AES");
		//} catch (Exception e) {
		//	System.out.println("Erreur pendant le calcul de la cle secrete partagee de 128 bits");
		//	e.printStackTrace();
		//}
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
		DiffieHellman alice = new DiffieHellman();
		DiffieHellman bob = new DiffieHellman();
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
