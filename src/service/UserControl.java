package service;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class UserControl {

    private ObservableList<User> lista =
            FXCollections.observableArrayList();

    private StringProperty nomeUsuario = new SimpleStringProperty("");
    private StringProperty funcaoUsuario = new SimpleStringProperty("");
    private StringProperty telefoneUsuario = new SimpleStringProperty("");
    private StringProperty empresaUsuario = new SimpleStringProperty("");

    public User getUserAtual() {
        return userAtual;
    }

    public void setUserAtual(User userAtual) {
        this.userAtual = userAtual;
    }

    private User userAtual;

    public void entityToBoundaryUser(User u) {
        if (u != null) {
            nomeUsuario.set(u.getNomeUsuario());
            funcaoUsuario.set(u.getFuncaoUsuario());
            telefoneUsuario.set(u.getTelefoneUsuario());
            empresaUsuario.set(u.getEmpresaUsuario());
        }
    }

    public void adicionarUser() {
        User u = new User();
        u.setNomeUsuario(nomeUsuario.get());
        u.setFuncaoUsuario(funcaoUsuario.get());
        u.setTelefoneUsuario(telefoneUsuario.get());
        u.setEmpresaUsuario(empresaUsuario.get());
        lista.add(u);
    }

    public void pesquisarUser() {
        for (User u : lista) {
            if (u.getNomeUsuario().contains(nomeUsuario.get())) {
                entityToBoundaryUser(u);
                break;
            }
        }
    }

    public void apagarUser() {
        if (this.userAtual != null) {
            lista.remove(userAtual);
        }
    }

    public StringProperty nomeUsuarioProperty() {
        return nomeUsuario;
    }
    public StringProperty funcaoUsuarioProperty() {
        return funcaoUsuario;
    }
    public StringProperty telefoneUsuarioProperty() {
        return telefoneUsuario;
    }
    public StringProperty empresaUsuarioProperty() {
        return empresaUsuario;
    }

    public ObservableList<User> getListaUser() {
        return this.lista;
    }
}
