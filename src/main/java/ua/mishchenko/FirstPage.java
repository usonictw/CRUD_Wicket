package ua.mishchenko;

import org.apache.wicket.Page;
import org.apache.wicket.PageReference;
import org.apache.wicket.extensions.ajax.markup.html.modal.ModalWindow;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;

public class FirstPage extends WebPage {

    String passValue;

    @SuppressWarnings("serial")
    public FirstPage() {

        addComponents();
        //passValue = "This value is passed to the modal window.";

        //add(new SimplePanel("panel"));
        //add(new SimplePanel("panel1"));
    }

    private  void addComponents(){
        Form<?> form = new Form<Object>("form");
        add(form);
    }
}
