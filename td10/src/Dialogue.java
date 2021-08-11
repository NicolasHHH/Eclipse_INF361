import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.text.BadLocationException;

public class Dialogue {
	private static int frameCount = 0;

	private final JFrame frame;
	private Client client = null;
	public final PrintWriter affichage;

	public Dialogue(int shiftx, int shifty) {
		this.frame = new JFrame();
		this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		//
		final JTextArea panel = new JTextArea(10, 10);
		panel.setEditable(false);
		JScrollPane pane = new JScrollPane(panel);
		this.frame.add(pane);
		//
		Writer writer = new Writer() {
			@Override
			public void write(char[] cbuf, int off, int len) throws IOException {
				panel.append(new String(cbuf, off, len));
				try {
					panel.setCaretPosition(panel.getLineStartOffset(panel.getLineCount() - 1));
				} catch (BadLocationException e) { //
				}
			}

			@Override
			public void flush() throws IOException { //
			}

			@Override
			public void close() throws IOException { //
			}
		};
		this.affichage = new PrintWriter(writer);
		//
		final JTextField input = new JTextField(50);
		ActionListener listener;
		listener = new ActionListener() {
			@SuppressWarnings("synthetic-access")
			@Override
			public void actionPerformed(ActionEvent e) {
				String line = e.getActionCommand();
				if (Dialogue.this.client != null)
					synchronized (Dialogue.this.client) {
						Dialogue.this.client.recevoirDuClavier(line);
					}
				Dialogue.this.affichage.println(line);
				input.setText(null);
			}
		};
		input.addActionListener(listener);
		this.frame.add(input, BorderLayout.SOUTH);
		//
		this.frame.setSize(300, 100);
		// this.frame.pack();
		++frameCount;
		this.frame.setLocation(20 * frameCount + shiftx, 20 * frameCount + shifty);
		this.frame.setVisible(true);
	}

	public void attacher(Client c) {
		if (this.client != null)
			throw new IllegalStateException("this Dialogue is already bound to another client");
		if (c == null)
			throw new AssertionError("Client parameter is null");
		this.client = c;
		this.frame.setTitle(c.getPseudo());
	}

}
