/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package investments.BOLO;

/**
 *
 * @author Stuart
 */
public class FactorForm
{
    Long id;
    Long investmentId;    
    String name;
    String description;
    
    public Long getInvestmentId()
    {
        return investmentId;
    }

    public void setInvestmentId(Long investmentId)
    {
        this.investmentId = investmentId;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }
    
}