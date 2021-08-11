import tc.TC;

public class TestPGCDRec {

	public static void testInt() {
		boolean ok = true;
		TC.println("Test du pgcd euclidien");
		int a=1794;
		int b=2014;
		int res = PGCDRec.pgcd(a,b);
		ok &= (res==2);
		TC.println("pgcd("+a+','+b+")="+res);
		res = PGCDRec.pgcd(b,a);
		ok &= (res==2);
		TC.println("pgcd("+b+','+a+")="+res);
		res = PGCDRec.pgcd(a,a);
		ok &= (res==1794);
		TC.println("pgcd("+a+','+a+")="+res);
		a=31175;
		b=76923689;
		res = PGCDRec.pgcd(a,b);
		ok &= (res==1247);
		TC.println("pgcd("+a+","+b+")="+res);
		if (ok) {
			TC.println("PGCD OK");
		} else {
			TC.println("PGCD KO :( !");
		}
	}
	public static void main(String[] args) {
		testInt();
		TC.println();
	}
}
