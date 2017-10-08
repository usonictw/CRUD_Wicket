package ua.mishchenko;

import org.apache.wicket.Page;
import org.apache.wicket.PageReference;
import org.apache.wicket.extensions.ajax.markup.html.modal.ModalWindow;
import org.apache.wicket.markup.html.WebPage;

public class FirstPage extends WebPage {

    String passValue;

    @SuppressWarnings("serial")
    public FirstPage() {

        //passValue = "This value is passed to the modal window.";

        add(new SimplePanel("panel"));
        //add(new SimplePanel("panel1"));
    }
}
