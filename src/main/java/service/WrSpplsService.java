package service;
import model.WrSppls;
import java.util.List;
public interface WrSpplsService
{
    void create(WrSppls wrs);
    List <WrSppls> readAll();
    WrSppls read(int id);
    boolean update(WrSppls wrs, int id);
    boolean delete(int id);

}
