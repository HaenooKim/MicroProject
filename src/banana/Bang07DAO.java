package banana;

import java.util.List;

public interface Bang07DAO {
	public List<Bang07VO> findAll() throws Exception;
	public Bang07VO findByPk(Bang07VO pvo) throws Exception;
	public int delByPK (Bang07VO pvo) throws Exception;
	public int add(Bang07VO pvo) throws Exception;
} 
