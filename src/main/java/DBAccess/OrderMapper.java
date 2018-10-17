package DBAccess;

import FunctionLayer.LegoHouseException;
import FunctionLayer.Order;
import FunctionLayer.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderMapper {

    public static void createOrder(Order order, User user) throws LegoHouseException {
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO `order` (length, width, layers, user_id) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, order.getLength());
            ps.setInt(2, order.getWidth());
            ps.setInt(3, order.getLayers());
            ps.setInt(4, user.getId());
            ps.executeUpdate();
            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            int id = ids.getInt(1);
            order.setId(id);

        } catch (SQLException | ClassNotFoundException ex) {
            throw new LegoHouseException(ex.getMessage());
        }
    }

    public static List<Order> getUserOrders(User user) throws LegoHouseException {
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT * FROM `order` WHERE user_id=?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, user.getId());
            ResultSet rs = ps.executeQuery();
            List<Order> orders = new ArrayList<>();
            while (rs.next()) {
                int orderId = rs.getInt("id");
                int length = rs.getInt("length");
                int width = rs.getInt("width");
                int layers = rs.getInt("layers");

                Order order = new Order(length, width, layers);
                order.setId(orderId);
                orders.add(order);
            }
            return orders;

        } catch (ClassNotFoundException | SQLException ex) {
            throw new LegoHouseException(ex.getMessage());
        }
    }

    public static List<Order> getAllInvoiceId() throws LegoHouseException {
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT * FROM `order`";
            PreparedStatement pstmt = con.prepareStatement(SQL);
            ResultSet rs = pstmt.executeQuery();
            List<Order> orders = new ArrayList<>();
            while (rs.next()) {
                int orderId = rs.getInt("id");
                int length = rs.getInt("length");
                int width = rs.getInt("width");
                int layers = rs.getInt("layers");

                Order order = new Order(length, width, layers);
                order.setId(orderId);
                orders.add(order);
            }
            return orders;
        } catch (Exception ex) {
            throw new LegoHouseException(ex.getMessage());
        }

    }

}
