/**
 * 
 */
package com.person.myspringboot.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static org.apache.commons.lang3.StringUtils.isNotBlank;
import org.hibernate.validator.internal.util.privilegedactions.GetAnnotationParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.person.myspringboot.dto.GameKaifu;




/**
 * @author liuquan
 *
 */
@Repository("gameKaifuDao")
public class GameKaifuDaoImpl implements GameKaifuDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public GameKaifu get(Object id) {
		String sql = "select * from game_kaifu where id = ?";
		BeanPropertyRowMapper<GameKaifu> rowMapper = new BeanPropertyRowMapper<GameKaifu>(GameKaifu.class);
		rowMapper.setPrimitivesDefaultedForNullValue(true);
		List<GameKaifu> list = jdbcTemplate.query(sql.toString(), new Object[] { id }, rowMapper);
		if (list.size() > 0) {
			return list.get(0);
		}
		return null;
	}
	
	@Override
	public int delete(Object id) {
		String sql = "delete from game_kaifu where id = ?";
		return jdbcTemplate.update(sql, id);
	}
	
	@Override
	public int update(GameKaifu entity) {
		int rowsAffected;
		StringBuilder sql = new StringBuilder();
		sql.append("update game_kaifu set ");

		List<Object> params = new ArrayList<Object>();

		if (isNotBlank(entity.getGameId())) {
			sql.append("game_id=?,");
			params.add(entity.getGameId());
		}
		if (entity.getStatus() != null) {
			sql.append("status = ?,");
			params.add(entity.getStatus());
		}

		sql.deleteCharAt(sql.length() - 1);
		sql.append(" where id =? ");
		params.add(entity.getId());

		rowsAffected = jdbcTemplate.update(sql.toString(), params.toArray());

		return rowsAffected;
	}
	
	@Override
	public void insert(GameKaifu entity) {
		final String sql = "insert into game_kaifu(game_id,game_name,status) values(?,?,?)";
		jdbcTemplate.update(sql,entity.getGameId(),entity.getGameName(),entity.getStatus());
		return ;
	}
	
	@Override
	public Number save(GameKaifu entity) {
		final String sql = "insert into game_kaifu(game_id,game_name,status) values(?,?,?)";
		KeyHolder keyHolder = new GeneratedKeyHolder();

		jdbcTemplate.update(new PreparedStatementCreator() {
			public java.sql.PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
				int i = 0;
				java.sql.PreparedStatement ps = conn.prepareStatement(sql);
				ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				ps.setString(++i, entity.getGameId());
				ps.setString(++i, entity.getGameName());
				ps.setInt(++i, entity.getStatus());
				return ps;
			}
		}, keyHolder);
		
		return keyHolder.getKey();
	}
	
	
	

}
