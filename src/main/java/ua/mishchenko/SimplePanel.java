package ua.mishchenko;


import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.SubmitLink;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.PropertyModel;
import ua.mishchenko.model.User;

import java.util.ArrayList;
import java.util.List;

public class SimplePanel extends Panel{
    List<String> genderChoice = new ArrayList<>();

    public SimplePanel(String id) {
        super(id);

        final User user = new User();
        genderChoice.add("Male");
        genderChoice.add("Female");

        Form<?> form = new Form("form");
        final TextField<String> textFieldName =
                new TextField<String>("firstName", new PropertyModel<String>(user, "firstName"));
        textFieldName.setOutputMarkupId(true);
        final TextField<String> textFieldSurname =
                new TextField<String>("surname", new PropertyModel<String>(user, "surname"));
        textFieldSurname.setOutputMarkupId(true);
        DropDownChoice<String> gender =
                new DropDownChoice<String>("gender", new PropertyModel<String>(user, "gender"), genderChoice);

        SubmitLink submitLink = new SubmitLink("submit"){
            @Override
            public void onSubmit() {
                super.onSubmit();
                System.out.println("First Name " + user.getFirstName());
                System.out.println("Surname " + user.getSurname());
                System.out.println("Gender " + user.getGender());
                textFieldName.setEnabled(false);
                textFieldSurname.setEnabled(false);

            }
        };

        AjaxButton ajaxButton = new AjaxButton("submitAjax") {
            @Override
            protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
                super.onSubmit(target, form);
                textFieldName.setEnabled(false);
                textFieldSurname.setEnabled(false);
            }
        };


/*        Button button = new Button("button"){
            @Override
            public void onSubmit() {
                super.onSubmit();
                System.out.println("First Name " + user.getFirstName());
                System.out.println("Surname " + user.getSurname());
                System.out.println("Gender " + user.getGender());
            }
        };
*/

        add(form);
        form.add(textFieldName);
        form.add(textFieldSurname);
        form.add(gender);
        form.add(submitLink);
    }
}
