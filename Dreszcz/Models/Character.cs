using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Dreszcz.Models
{
    public class Character
    {
        public int CharacterId { get; set; }

        public string Login { get; set; }

        //add character attributes here

        public virtual ApplicationUser User { get; set; }
        public string ApplicationUserId { get; set; }
    }
}