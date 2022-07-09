package service;
import model.WrSppls;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class WrSpplsServiceImpl implements WrSpplsService {

    private static final Map<Integer, WrSppls> WRSPPLS_REPOSITORY_MAP = new HashMap<>();
    private static final AtomicInteger WRSPPLS_ID_HOLDER = new AtomicInteger();

    @Override
    public void create(WrSppls wrs) {
        final int wrsId = WRSPPLS_ID_HOLDER.incrementAndGet();
        wrs.setSerial_number(wrsId);
        WRSPPLS_REPOSITORY_MAP.put(wrsId, wrs);
    }

    @Override
    public List<WrSppls> readAll() {
        return new ArrayList<>(WRSPPLS_REPOSITORY_MAP.values());
    }

    @Override
    public WrSppls read(int id)
    {
        return WRSPPLS_REPOSITORY_MAP.get(id);
    }

    @Override
    public boolean update(WrSppls wrs, int id)
    {
        if (WRSPPLS_REPOSITORY_MAP.containsKey(id)) {
            wrs.setSerial_number(id);
            WRSPPLS_REPOSITORY_MAP.put(id, wrs);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int id)
    {
        return WRSPPLS_REPOSITORY_MAP.remove(id) != null;
    }
}
