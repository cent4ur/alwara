package hu.cent4ur.alwara.web;

import hu.cent4ur.alwara.model.Line;
import hu.cent4ur.alwara.model.Link;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

import javax.enterprise.context.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 * Managing lines.
 * 
 * @author Sandor Balazs
 */
@Named
@SessionScoped
public class LineBean implements Serializable {

    private static final long serialVersionUID = -422117264281622377L;
    private static final Logger logger = Logger.getLogger(LineBean.class.getName());
    private final EntityManager entityManager;
    private String lineName;

    public LineBean() {
        EntityManagerFactory emf = Persistence
                .createEntityManagerFactory("AlwaraPersistenceUnit");
        entityManager = emf.createEntityManager();
    }

    public void saveLine(ActionEvent evt) {
        logger.info("saveLine() - Save line information.");
        entityManager.getTransaction().begin();
        Line line = new Line(lineName);
        entityManager.persist(line);
        entityManager.getTransaction().commit();
    }

    public List<Line> getLines() {
        logger.info("getLines() - Query all lines.");
        TypedQuery<Line> query = entityManager.createNamedQuery("Line.findAll",
                Line.class);
        return query.getResultList();
    }

    public List<Link> getLinks() {
        logger.info("getLinks() - Query all links.");
        TypedQuery<Link> query = entityManager.createNamedQuery("Link.findAll",
                Link.class);
        return query.getResultList();
    }
}
