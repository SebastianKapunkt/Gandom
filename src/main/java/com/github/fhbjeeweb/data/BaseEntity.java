package com.github.fhbjeeweb.data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

/**
 * <p>
 * Abstract transfer object with an <tt>id</tt> and a <tt>name</tt>.</p>
 * <p>
 * Transfer objects will be persisted.</p>
 * <p>
 * The <tt>name</tt> must not be <tt>null</tt>.</p>
 * <p>
 * Two Instances of BaseEntity are considered equal if their names converted
 * to lowercase are equal.</p>
 * <p>
 * Instances of BaseEntity are ordered using the natural ordering of their names
 * converted to lowercase.</p>
 */
@MappedSuperclass
public abstract class BaseEntity implements Comparable<BaseEntity>{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "The name must not be empty")
    private String name;

    public BaseEntity() {}

    public BaseEntity(String name) {
        this.name = name;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name.trim();
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + ": " + name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BaseEntity)) return false;
        BaseEntity that = (BaseEntity) o;
        // handle null
        if (name == null || that.name == null ) return false;

        return name.toLowerCase().equals(that.name.toLowerCase());
    }

    @Override
    public int hashCode() {
        // FIXME: This null check was introduced to avoid a NullPointerException
        // It should not be possible anywhere in the code to have an empty name
        // When the problem is fixed elsewhere the null check might be removed
        if (name == null) return 0;
        return name.toLowerCase().hashCode();
    }

    @Override
    public int compareTo(BaseEntity o) {
        return String.CASE_INSENSITIVE_ORDER.compare(getName(), o.getName());
    }
}