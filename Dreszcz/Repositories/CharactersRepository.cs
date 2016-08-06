using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Data.Entity.Core.Objects;
using System.Linq;
using System.Linq.Expressions;
using System.Web;
using System.Web.Razor.Generator;
using Dreszcz.Models;

namespace Dreszcz.Repositories
{
    public interface ICharactersRepository
    {
        IQueryable<Character> All { get; }
        IQueryable<Character> AllIncluding(params Expression<Func<Character, object>>[] includeProperties);
        Character Find(int id);
        Character getCurrentCharacter(String id);
        void InsertOrUpdate(Character character);
        void Delete(int id);
        void Save();
    }

    public class CharactersRepository : ICharactersRepository
    {
        private ApplicationDbContext context = new ApplicationDbContext();

        public IQueryable<Character> All
        {
            get { return context.Characters; }
        }

        public IQueryable<Character> AllIncluding(params Expression<Func<Character, object>>[] includeProperties)
        {
            IQueryable<Character> query = context.Characters;
            foreach (var includeProperty in includeProperties)
            {
                query = query.Include(includeProperty);
            }
            return query;
        }

        public Character Find(int id)
        {
            return context.Characters.Find(id);
        }

        public void InsertOrUpdate(Character character)
        {
            if (character.CharacterId == 0)
            {
                context.Characters.Add(character);
                Save();
            }
            else
            {
                context.Entry(character).State = EntityState.Modified;
                Save();
            }
        }

        public Character getCurrentCharacter(String id)
        {
            Character character = context.Characters.FirstOrDefault(c => c.ApplicationUserId == id);
            return character;
        }

        public void Delete(int id)
        {
            Character character = Find(id);
            context.Characters.Remove(character);
            Save();
        }

        public void Save()
        {
            context.SaveChanges();
        }
    }
}