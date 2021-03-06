package org.repositoryminer.persistence.model;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.repositoryminer.scm.DiffType;

/**
 * This class represents the "change" object in the database. This class
 * represents the changes made in a commit.
 */
public class DiffDB {

	private String path;
	private String oldPath;
	private String hash;
	private int linesAdded;
	private int linesRemoved;
	private DiffType type;

	public DiffDB() {
	}

	public static List<Document> toDocumentList(List<DiffDB> diffs) {
		List<Document> list = new ArrayList<Document>();
		for (DiffDB d : diffs) {
			Document doc = new Document();
			doc.append("path", d.getPath()).append("old_path", d.getOldPath()).append("hash", d.getHash())
					.append("lines_added", d.getLinesAdded()).append("lines_removed", d.getLinesRemoved())
					.append("type", d.getType().toString());
			list.add(doc);
		}
		return list;
	}

	public DiffDB(String path, String oldPath, String hash, int linesAdded, int linesRemoved, DiffType type) {
		super();
		this.path = path;
		this.oldPath = oldPath;
		this.hash = hash;
		this.linesAdded = linesAdded;
		this.linesRemoved = linesRemoved;
		this.type = type;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getOldPath() {
		return oldPath;
	}

	public void setOldPath(String oldPath) {
		this.oldPath = oldPath;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public int getLinesAdded() {
		return linesAdded;
	}

	public void setLinesAdded(int linesAdded) {
		this.linesAdded = linesAdded;
	}

	public int getLinesRemoved() {
		return linesRemoved;
	}

	public void setLinesRemoved(int linesRemoved) {
		this.linesRemoved = linesRemoved;
	}

	public DiffType getType() {
		return type;
	}

	public void setType(DiffType type) {
		this.type = type;
	}

}