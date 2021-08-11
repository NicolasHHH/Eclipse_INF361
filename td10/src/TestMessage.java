import tc.TC;

public class TestMessage {

	public static void main(String[] args) {
		TC.println(new Message("glop"));
		TC.println(new Message("a;b;HELLO"));
		TC.println(new Message("a;b;__HELLO__"));
		TC.println(new Message("a;b;__MESSAGE__;0;1;blah"));
	}

}
