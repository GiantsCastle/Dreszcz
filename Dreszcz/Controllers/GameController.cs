using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Dreszcz.Controllers
{
    public class GameController : Controller
    {
        // GET: Game
        public ActionResult Index(int? paragraf)
        {
            if (paragraf != null)
                return View("paragraf" + paragraf);
            else
                return View();
        }
    }
}