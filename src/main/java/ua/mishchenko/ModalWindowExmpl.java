package ua.mishchenko;

import org.apache.wicket.Page;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.extensions.ajax.markup.html.modal.ModalWindow;
import org.apache.wicket.extensions.ajax.markup.html.modal.ModalWindow.PageCreator;
import org.apache.wicket.extensions.ajax.markup.html.modal.ModalWindow.WindowClosedCallback;
import org.apache.wicket.markup.html.WebPage;


public class ModalWindowExmpl extends WebPage {

    private final ModalWindow modalWindow;

    public ModalWindowExmpl() {
        modalWindow = new ModalWindow("modalWindow");
        modalWindow.setPageCreator(new PageCreator() {
            @Override
            public Page createPage() {
                return new FirstPage();
            }
        });

        modalWindow.setTitle("ModalWindowExmpl");
        modalWindow.setWindowClosedCallback(new WindowClosedCallback() {
            @Override
            public void onClose(AjaxRequestTarget ajaxRequestTarget) {

            }
        });

        add(new AjaxLink<String>("viewLink") {
            @Override
            public void onClick(AjaxRequestTarget ajaxRequestTarget) {
                modalWindow.show(ajaxRequestTarget);
            }
        });

        add(modalWindow);
    }
}
