using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Dreszcz.Models
{
    public enum Eliksir { Zrecznosc, Wytrzymalosc, Szczescie };

    public class Character
    {
        public int CharacterId { get; set; }

        public string Login { get; set; }

        //add character attributes here
        public Eliksir eliksir { get; set; }

        //Zmienne
        public bool doorOpen { get; set; }

        public virtual ApplicationUser User { get; set; }
        public string ApplicationUserId { get; set; }

        public Character()
        {
            this.doorOpen = false;
        }
    }
}