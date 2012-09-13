/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.usp.ime.faguilar.guis;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author frank
 */
@Entity
@Table(name = "EMUSER", catalog = "", schema = "FRANK")
@NamedQueries({
    @NamedQuery(name = "Emuser.findAll", query = "SELECT e FROM Emuser e"),
    @NamedQuery(name = "Emuser.findByNickname", query = "SELECT e FROM Emuser e WHERE e.nickname = :nickname"),
    @NamedQuery(name = "Emuser.findByFirstname", query = "SELECT e FROM Emuser e WHERE e.firstname = :firstname"),
    @NamedQuery(name = "Emuser.findByLastname", query = "SELECT e FROM Emuser e WHERE e.lastname = :lastname"),
    @NamedQuery(name = "Emuser.findByAdmin", query = "SELECT e FROM Emuser e WHERE e.admin = :admin"),
    @NamedQuery(name = "Emuser.findByInputdbmathexpressions", query = "SELECT e FROM Emuser e WHERE e.inputdbmathexpressions = :inputdbmathexpressions"),
    @NamedQuery(name = "Emuser.findByPassword", query = "SELECT e FROM Emuser e WHERE e.password = :password"),
    @NamedQuery(name = "Emuser.findByCurrentmodel", query = "SELECT e FROM Emuser e WHERE e.currentmodel = :currentmodel")})
public class Emuser implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "NICKNAME")
    private String nickname;
    @Column(name = "FIRSTNAME")
    private String firstname;
    @Column(name = "LASTNAME")
    private String lastname;
    @Column(name = "ADMIN")
    private Integer admin;
    @Column(name = "INPUTDBMATHEXPRESSIONS")
    private Integer inputdbmathexpressions;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "CURRENTMODEL")
    private Integer currentmodel;

    public Emuser() {
    }

    public Emuser(String nickname) {
        this.nickname = nickname;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        String oldNickname = this.nickname;
        this.nickname = nickname;
        changeSupport.firePropertyChange("nickname", oldNickname, nickname);
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        String oldFirstname = this.firstname;
        this.firstname = firstname;
        changeSupport.firePropertyChange("firstname", oldFirstname, firstname);
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        String oldLastname = this.lastname;
        this.lastname = lastname;
        changeSupport.firePropertyChange("lastname", oldLastname, lastname);
    }

    public Integer getAdmin() {
        return admin;
    }

    public void setAdmin(Integer admin) {
        Integer oldAdmin = this.admin;
        this.admin = admin;
        changeSupport.firePropertyChange("admin", oldAdmin, admin);
    }

    public Integer getInputdbmathexpressions() {
        return inputdbmathexpressions;
    }

    public void setInputdbmathexpressions(Integer inputdbmathexpressions) {
        Integer oldInputdbmathexpressions = this.inputdbmathexpressions;
        this.inputdbmathexpressions = inputdbmathexpressions;
        changeSupport.firePropertyChange("inputdbmathexpressions", oldInputdbmathexpressions, inputdbmathexpressions);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        String oldPassword = this.password;
        this.password = password;
        changeSupport.firePropertyChange("password", oldPassword, password);
    }

    public Integer getCurrentmodel() {
        return currentmodel;
    }

    public void setCurrentmodel(Integer currentmodel) {
        Integer oldCurrentmodel = this.currentmodel;
        this.currentmodel = currentmodel;
        changeSupport.firePropertyChange("currentmodel", oldCurrentmodel, currentmodel);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nickname != null ? nickname.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Emuser)) {
            return false;
        }
        Emuser other = (Emuser) object;
        if ((this.nickname == null && other.nickname != null) || (this.nickname != null && !this.nickname.equals(other.nickname))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "GUIs.Emuser[nickname=" + nickname + "]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

}
