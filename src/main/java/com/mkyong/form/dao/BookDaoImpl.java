package com.mkyong.form.dao;

import com.mkyong.form.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Repository
public class BookDaoImpl implements BookDao {

	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) throws DataAccessException {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	@Override
	public Book findById(Integer id) {

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);

		String sql = "SELECT * FROM book WHERE id=:id";

		Book result = null;
		try {
			result = namedParameterJdbcTemplate.queryForObject(sql, params, new BookMapper());
		} catch (EmptyResultDataAccessException e) {
		}

		return result;

	}

	@Override
	public List<Book> findAll() {

		String sql = "SELECT * FROM book";
		List<Book> result = namedParameterJdbcTemplate.query(sql, new BookMapper());

		return result;

	}

	@Override
	public void save(Book book) {

		KeyHolder keyHolder = new GeneratedKeyHolder();
		
		String sql = "INSERT INTO BOOK(TITLE, YEAR, AUTHOR, COVER, CATEGORY) "
				+ "VALUES ( :title, :year, :author, :cover, :category)";

		namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(book), keyHolder);
		book.setId(keyHolder.getKey().intValue());
		
	}

	@Override
	public void update(Book book) {

		String sql = "UPDATE BOOK SET TITLE=:title, YEAR=:year, AUTHOR=:author, " + "COVER=:cover, "
				+ "CATEGORY=:category WHERE id=:id";

		namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(book));

	}

	@Override
	public void delete(Integer id) {

		String sql = "DELETE FROM BOOK WHERE id= :id";
		namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource("id", id));

	}

	private SqlParameterSource getSqlParameterByModel(Book book) {

		// Unable to handle List<String> or Array
		// BeanPropertySqlParameterSource

		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("id", book.getId());
		paramSource.addValue("title", book.getTitle());
		paramSource.addValue("year", book.getYear());
		paramSource.addValue("author", book.getAuthor());
		paramSource.addValue("cover", book.getCover());

		// join String
		paramSource.addValue("category", book.getCategory());

		return paramSource;
	}

	private static final class BookMapper implements RowMapper<Book> {

		public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
			Book book = new Book();
			book.setId(rs.getInt("id"));
			book.setTitle(rs.getString("title"));
			book.setYear(rs.getString("year"));
			book.setAuthor(rs.getString("author"));
			book.setCategory(rs.getString("category"));
			book.setCover(rs.getString("cover"));
			return book;
		}
	}

	private static List<String> convertDelimitedStringToList(String delimitedString) {

		List<String> result = new ArrayList<String>();

		if (!StringUtils.isEmpty(delimitedString)) {
			result = Arrays.asList(StringUtils.delimitedListToStringArray(delimitedString, ","));
		}
		return result;

	}

	private String convertListToDelimitedString(List<String> list) {

		String result = "";
		if (list != null) {
			result = StringUtils.arrayToCommaDelimitedString(list.toArray());
		}
		return result;

	}

}