package unosim;

import org.eclipse.swt.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.events.*;
import org.eclipse.swt.graphics.*;


public class GameSetup {
	
	
	public static void InitUI() {
		//This initializes the essential elements
	    Display display = new Display();
	    Shell shell = new Shell(display);
	    shell.setText("unosim");
	    shell.setSize(410, 310);
	    
	    //This sets up the grid layout for th entire window
	    //all new widgets initialized are added orderly into the window grid
	    GridLayout gridLayout = new GridLayout();
	    gridLayout.numColumns = 4; //three columns to work with
	    shell.setLayout(gridLayout);
	    
	    //Setting up the first label:
	    //It doesn't need to be saved to a variable, rememember this principle
	    new Label(shell, SWT.NULL).setText("Choose profile");
	    
	    //filling up the next two grid slots
	    //first is the description label
	    new Label(shell, SWT.NULL).setText("Description");
	    //second is an empty label to fill empty space
	    new Label(shell, SWT.NULL).setText("");
	    new Label(shell, SWT.NULL).setText("");
		
	    //This sets up the card profiles
	    List profiles = new List(shell, SWT.MULTI | SWT.BORDER | SWT.V_SCROLL);
	    profiles.setItems(new String [] {
	          "UNO", "DOS",    
	          "UNO+DOS", "Custom"
	       }); //Initializing a reusable gridData object
	    GridData gridData = new GridData(GridData.HORIZONTAL_ALIGN_FILL | GridData.VERTICAL_ALIGN_FILL);
	    gridData.verticalSpan = 7; //does this influence the vertical position of new widgets?
	    gridData.horizontalSpan = 1;
	    //this is all unnecesary fluff for static windows. 
	    //But it actually scales with the other widgets, it's pretty nice
	    int listHeight = profiles.getItemHeight() * 6;
	    Rectangle trim = profiles.computeTrim(0, 0, 0, listHeight);
	    gridData.heightHint = trim.height;
	    profiles.setLayoutData(gridData);
	    
	    //This sets up the description of settings
	    Text settingDescription = new Text(shell, SWT.MULTI);
	    settingDescription.setText("This is the setting description");
	    gridData = new GridData(GridData.HORIZONTAL_ALIGN_FILL | GridData.VERTICAL_ALIGN_FILL);
	    gridData.verticalSpan = 1; //does this influence the vertical position of new widgets?
	    gridData.horizontalSpan = 3;
	    gridData.heightHint = 80; //trim.height;
	    gridData.widthHint = 280; //trim.width;
	    settingDescription.setLayoutData(gridData);
	    
	    
	    //This section is setting up the mechanics options
	    Label mechanics = new Label(shell, SWT.NONE);
	    mechanics.setText("Mechanics");
	    Button unoMechanics = new Button(shell, SWT.CHECK);
	    unoMechanics.setText("uno");
	    Button dosMechanics = new Button(shell, SWT.CHECK);
	    dosMechanics.setText("dos");
	    
	    //This section sets up the draw type
	    Label drawType = new Label(shell, SWT.NONE);
	    drawType.setText("Draw Type");
	    Button drawAndPlay = new Button(shell, SWT.RADIO);
	    drawAndPlay.setText("draw and play");
	    Button drawOnly = new Button(shell, SWT.RADIO);
	    drawOnly.setText("draw only");
	    
	    //common rules header
	    new Label(shell, SWT.NONE).setText("Common rules:");
	    new Label(shell, SWT.NULL).setText("");
	    new Label(shell, SWT.NULL).setText("");
	    
	    //This section sets up all the checkmark buttons
	    Button callUno = new Button(shell, SWT.CHECK);
	    callUno.setText("Call uno");
	    Button cardStack = new Button(shell, SWT.CHECK);
	    cardStack.setText("Card stacking");
	    Button challengePlus = new Button(shell, SWT.CHECK);
	    challengePlus.setText("Challenge + 4");
	    Button callDos = new Button(shell, SWT.CHECK);
	    callDos.setText("Call dos");
	    Button jumpin = new Button(shell, SWT.CHECK);
	    jumpin.setText("Jump-In");
	    Button forceWild = new Button(shell, SWT.CHECK);
	    forceWild.setText("Force wild");
	    Button infiniteDeck = new Button(shell, SWT.CHECK);
	    infiniteDeck.setText("Infinite deck");
	    Button swapping = new Button(shell, SWT.CHECK);
	    swapping.setText("0/7 swapping");
	    Button restrictedDraw = new Button(shell, SWT.CHECK);
	    restrictedDraw.setText("restricted draw");
	    
	    //This sets up the "advanced" button in the middle
	    Button advancedSettings = new Button(shell, SWT.PUSH);
	    advancedSettings.setText("Advanced");
	    gridData = new GridData(GridData.HORIZONTAL_ALIGN_CENTER | GridData.VERTICAL_ALIGN_FILL);
	    advancedSettings.setLayoutData(gridData);
	    
	    //Here are all the listeners
	    advancedSettings.addListener(SWT.Selection, new Listener() {
		      public void handleEvent(Event e) {
		        switch (e.type) {
		        case SWT.Selection:
		          System.out.println("haha gamer");
		          Shell subshell = new Shell(shell);
		  		  subshell.setText("super avanzado");
				  subshell.setSize(100, 100);
				  Label p = new Label(subshell, SWT.PUSH);//?????????????
			      p.setText("prosigue prosigue");
				  p.setBounds(10, 10, 200, 100);
		          subshell.open();
		          if (cardStack.getSelection()) {
			          System.out.println("ESTE TIPO JUEGA UNO");
			          p.setText("This man card stacks");
		          }
		          break;
		        }
		      }
		    });
	    
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
	
