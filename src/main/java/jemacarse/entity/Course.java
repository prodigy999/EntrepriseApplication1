package jemacarse.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Course implements Serializable {

    public enum EtatCourse {

        PAYE, IMPAYE
    }

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String commentaireChauffeur, commentaireClient;
    private double montant, distance, noteChauffeur, noteClient;
    private double posDepartClient [][], posDepartChauffeur [][], posArrivee [][];
    private Integer idClient, idChauffeur;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCourse;

    @Enumerated(EnumType.STRING)
    private EtatCourse etatCourse;

    @ManyToOne
    @JoinColumn(name = "personne_id")
    private Personne personne;

    @ManyToOne
    @JoinColumn(name = "vehicule_id")
    private Vehicule vehicule;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCommentaireChauffeur() {
        return commentaireChauffeur;
    }

    public void setCommentaireChauffeur(String commentaireChauffeur) {
        this.commentaireChauffeur = commentaireChauffeur;
    }

    public String getCommentaireClient() {
        return commentaireClient;
    }

    public void setCommentaireClient(String commentaireClient) {
        this.commentaireClient = commentaireClient;
    }

    public Integer getIdClient() {
        return idClient;
    }

    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
    }

    public Integer getIdChauffeur() {
        return idChauffeur;
    }

    public void setIdChauffeur(Integer idChauffeur) {
        this.idChauffeur = idChauffeur;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getNoteChauffeur() {
        return noteChauffeur;
    }

    public void setNoteChauffeur(double noteChauffeur) {
        this.noteChauffeur = noteChauffeur;
    }

    public double getNoteClient() {
        return noteClient;
    }

    public void setNoteClient(double noteClient) {
        this.noteClient = noteClient;
    }

    public double[][] getPosDepartClient() {
        return posDepartClient;
    }

    public void setPosDepartClient(double[][] posDepartClient) {
        this.posDepartClient = posDepartClient;
    }

    public double[][] getPosDepartChauffeur() {
        return posDepartChauffeur;
    }

    public void setPosDepartChauffeur(double[][] posDepartChauffeur) {
        this.posDepartChauffeur = posDepartChauffeur;
    }

    public double[][] getPosArrivee() {
        return posArrivee;
    }

    public void setPosArrivee(double[][] posArrivee) {
        this.posArrivee = posArrivee;
    }

    public Date getDateCourse() {
        return dateCourse;
    }

    public void setDateCourse(Date dateCourse) {
        this.dateCourse = dateCourse;
    }

    public EtatCourse getEtatCourse() {
        return etatCourse;
    }

    public void setEtatCourse(EtatCourse etatCourse) {
        this.etatCourse = etatCourse;
    }

    public Personne getPersonne() {
        return personne;
    }

    public void setPersonne(Personne personne) {
        this.personne = personne;
    }

    public Vehicule getVehicule() {
        return vehicule;
    }

    public void setVehicule(Vehicule vehicule) {
        this.vehicule = vehicule;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Course)) {
            return false;
        }
        Course other = (Course) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jemacarse.entity.Course[ id=" + id + " ]";
    }
}
