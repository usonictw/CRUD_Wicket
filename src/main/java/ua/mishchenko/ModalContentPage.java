package ua.mishchenko;

import org.apache.wicket.Page;
import org.apache.wicket.extensions.ajax.markup.html.modal.ModalWindow;
import org.apache.wicket.markup.html.basic.Label;

public class ModalContentPage extends Page {

    public ModalContentPage(Object pageReference, ModalWindow modalWindowPage) {

        // Retrieve the passValue content for display.
        String passValue = ((LounchPage) modalWindowPage.getPage())
                .getPassValue();
        add(new Label("passValueLabel", passValue));

        // You can use the
        // ((LaunchPage)modalWindowPage.getPage()).setPassValue() method to
        // change the passValue variable of the launch/caller page.
    }


}
