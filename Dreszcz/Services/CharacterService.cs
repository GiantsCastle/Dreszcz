using Dreszcz.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Dreszcz.Services
{
    public class CharacterService
    {
        private ApplicationDbContext db;

        public CharacterService(ApplicationDbContext dbContext)
        {
            db = dbContext;
        }

        //id must be string!
        //method creating table in database corresponding to application individual user
        public void CreateCharacter(string login, string userId)
        {
            var character = new Character { Login = login, ApplicationUserId = userId };
            db.Characters.Add(character);
            db.SaveChanges();
        }
    }
}