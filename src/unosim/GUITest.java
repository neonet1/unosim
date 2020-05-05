package unosim;

import org.eclipse.swt.*; //I have no idea what this is
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.layout.*;

public class GUITest {


	public static void InitUI() {
		Display display = new Display();
		Shell shell = new Shell(display);
		
		
		Label label = new Label(shell, SWT.PUSH);//?????????????
		label.setText("broom?");
		label.setBounds(75, 125, 80, 30);
		
		
		shell.setLayout (new RowLayout (SWT.HORIZONTAL));
		Button uno = new Button (shell, SWT.RADIO);
		uno.setText("UNO");
		uno.setSelection(true);
		Button dos = new Button (shell, SWT.RADIO);
		dos.setText("DOS");
		Button unodos = new Button (shell, SWT.RADIO);
		unodos.setText("UNO+DOS");
		
	
		Button button1 = new Button(shell, SWT.PUSH); //what does PUSH do?
		button1.setText("yes");
		button1.setBounds(75, 40, 80, 30); //setBounds is a mix of Location and Size in that order
		button1.addListener(SWT.Selection, new Listener() {
		      public void handleEvent(Event e) {
		        switch (e.type) {
		        case SWT.Selection:
		          System.out.println("haha gamer");
		          Shell subshell = new Shell(shell);
		  		  subshell.setText("sub");
				  subshell.setSize(100, 100);
				  Label p = new Label(subshell, SWT.PUSH);//?????????????
			      p.setText("prosigue prosigue");
				  p.setBounds(10, 10, 100, 30);
		          subshell.open();
		          if (uno.getSelection()) {
			          System.out.println("ESTE TIPO JUEGA UNO");
			          p.setText("prosigue con UNO");
		          }
		          break;
		        }
		      }
		    });
		

		shell.setText("demo");
		shell.setSize(300, 200);
		shell.open();
		
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	public static void main(String[] args) {
		InitUI();
	}
	
}
