// package hibernateSedesYDepartamentos;

// import org.hibernate.Session;
// import org.hibernate.SessionFactory;
// import org.hibernate.cfg.Configuration;
// import org.hibernate.Transaction;
// import org.hibernate.query.Query;
// import org.hibernate.cfg.Configuration;
// import java.util.List;

// public class Test {
//     public static void main(String[] args) {

//         SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
//                 .addAnnotatedClass(Sede.class)
//                 .addAnnotatedClass(Departamento.class)
//                 .buildSessionFactory();


//         List<Integer> sedeIds = List.of(1, 2, 3);

//         try (Session session = factory.openSession()) {
//             Transaction tx = session.beginTransaction();


//             String hql = "SELECT d FROM Departamento d WHERE d.sede.id IN (:sedeIds)";
//             Query<Departamento> query = session.createQuery(hql, Departamento.class);
//             query.setParameterList("sedeIds", sedeIds);

//             List<Departamento> departamentos = query.getResultList();


//             for (Departamento d : departamentos) {
//                 System.out.println("Departamento ID: " + d.getId());
//                 System.out.println("Departamento Nombre: " + d.getNombre());
//                 System.out.println("Sede ID: " + d.getSede().getId());
//                 System.out.println("Sede Nombre: " + d.getSede().getNombre());
//                 System.out.println("---------------------------------");
//             }

//             tx.commit();
//         } finally {
//             factory.close();
//         }
//     }
// }

