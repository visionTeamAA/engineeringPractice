package testingProject.SampleDialog;

import ch.ivyteam.ivy.richdialog.exec.panel.IRichDialogPanel;
import ch.ivyteam.ivy.richdialog.rdpanels.RichDialogGridBagPanel;

/**
 * <p>SampleDialogPanel is a rich dialog panel implementation.
 *
 * <p>Please note that a rich dialog panel is not an instance of a Swing 
 * container, but of an ULCContainer. As such it can not be run 
 * or instantiated outside the ULC framework.
 */
@SuppressWarnings("all")
public class SampleDialogPanel extends RichDialogGridBagPanel 
implements IRichDialogPanel 
{ 
  /** Serial version id */
  private static final long serialVersionUID = 1L;
  
  /**
   * Create a new instance of SampleDialogPanel
   */
  public SampleDialogPanel()
  {
    super();
    initialize();
  }
  
  /**
   * This method initializes SampleDialogPanel
   * @return void
   */
  private void initialize()
  {
  }
}