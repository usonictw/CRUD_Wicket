package ua.mishchenko;


import org.apache.wicket.Page;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.extensions.ajax.markup.html.modal.ModalWindow;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.PropertyModel;

public class LounchPage extends WebPage {

    private String passValue;

    @SuppressWarnings("serial")
    public LounchPage() {

        passValue = "This value is passed to the modal window.";

        // Display the current content of the passValue variable. The
        // PropertyModel must be used, as the value can be changed.
        final Label passValueLabel;
        add(passValueLabel = new Label("passValueLabel",
                new PropertyModel<String>(this, "passValue")));
        passValueLabel.setOutputMarkupId(true);

        // Create the modal window.
        final ModalWindow modal;
        add(modal = new ModalWindow("modal"));
        modal.setCookieName("modal-1");

        modal.setPageCreator(new ModalWindow.PageCreator() {
            public Page createPage() {
                // Use this constructor to pass a reference of this page.
                return new ModalContentPage(LounchPage.this.getPageReference(),
                        modal);
            }
        });
        modal.setWindowClosedCallback(new ModalWindow.WindowClosedCallback() {
            public void onClose(AjaxRequestTarget target) {
                // The variable passValue might be changed by the modal window.
                // We need this to update the view of this page.
                target.add(passValueLabel);
            }
        });
        modal.setCloseButtonCallback(new ModalWindow.CloseButtonCallback() {
            public boolean onCloseButtonClicked(AjaxRequestTarget target) {
                // Change the passValue variable when modal window is closed.
                setPassValue("Modal window is closed by user.");
                return true;
            }
        });

        // Add the link that opens the modal window.
        add(new AjaxLink<Void>("showModalLink") {
            @Override
            public void onClick(AjaxRequestTarget target) {
                modal.show(target);
            }
        });
    }

    public String getPassValue() {
        return passValue;
    }

    public void setPassValue(String passValue) {
        this.passValue = passValue;
    }


}
