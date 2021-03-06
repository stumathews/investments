﻿using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Data.Entity.ModelConfiguration.Conventions;
using System.Linq;
using System.Web;
using WinInvestmentTracker.Models.DEL;

namespace WinInvestmentTracker.Models.DAL
{
    /// <summary>
    /// This will manage our interaction with the database
    /// </summary>
    public class ApplicationDbContext : DbContext
    {        
        public ApplicationDbContext() : base("ApplicationDbContext")
        {
            // The name of the connection string in web.config is passed into this constructor
        }

        public virtual DbSet<Investment> Investments { get; set; }
        public virtual DbSet<InvestmentGroup> Groups { get; set; }
        public virtual DbSet<InvestmentInfluenceFactor> Factors { get; set; }
        public virtual DbSet<InvestmentRisk> Risks { get; set; }
        public virtual DbSet<Region> Regions { get; set; }
        public virtual DbSet<InvestmentNote> Notes { get; set; }

        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            modelBuilder.Conventions.Remove<PluralizingTableNameConvention>();
        }
    }
}