/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package investments.db.del;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import org.springframework.data.neo4j.annotation.Fetch;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.NodeEntity;

/**
 * Models a risk: the possibility for the unexpected/impreciseness or inability to forcast with certainty.
 * @author Stuart
 */
@NodeEntity
public class Risk implements Serializable
{
    @GraphId
    private Long id;
    private String description;
    private RiskType type;
    private String name;
    
    @Fetch
    private Set<Investment> investments = new HashSet<>();
    
    public Risk()
    {
        
    }

    public Set<Investment> getInvestments()
    {
        return investments;
    }

    public void setInvestments(Set<Investment> investments)
    {
        this.investments = investments;
    }
    
    public void addInvestment(Investment investment)
    {
        investments.add(investment);
    }

    public Risk(String name, String description, RiskType type)
    {        
        this.description = description;
        this.type = type;
        this.name = name;
    }
    
    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public RiskType getType()
    {
        return type;
    }

    public void setType(RiskType type)
    {
        this.type = type;
    }

    public String getName()
    {
        return name;
    }

    /**
     * Description of the risk.
     * @param name of the risks
     */
    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.id);
        hash = 37 * hash + Objects.hashCode(this.description);
        hash = 37 * hash + Objects.hashCode(this.type);
        hash = 37 * hash + Objects.hashCode(this.name);
        return hash;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Risk other = (Risk) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (this.type != other.type) {
            return false;
        }
        return Objects.equals(this.name, other.name);
    }
    
   
}
