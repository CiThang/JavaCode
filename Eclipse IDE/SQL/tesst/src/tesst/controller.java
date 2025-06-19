package tesst;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class controller implements ActionListener {

	private view v;

	public controller(view v) {
		super();
		this.v = v;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String st = e.getActionCommand();
		if(st.equals("1")) {
			this.v.panel_1.setVisible(true);
			this.v.panel.setVisible(false);

		} else if(st.equals("2")) {
			this.v.panel_1.setVisible(false);
			this.v.panel.setVisible(true);
			
		}
		
	}
	
	
}
