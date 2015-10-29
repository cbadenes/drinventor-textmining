{
  "uri" : "sig2012a-a157-rivers_PROC.xml",
  "url" : "/Users/cbadenes/Documents/OEG/Projects/DrInventor/datasets/acm-siggraph-2006-2014-upf/sig2012a/a157-rivers_PROC.xml",
  "source" : {
    "name" : "SIGGRAPH",
    "uri" : "http://drinventor/SIGGRAPH",
    "url" : "http://drinventor/SIGGRAPH",
    "protocol" : "http"
  },
  "metainformation" : {
    "title" : "Sculpting by Numbers",
    "published" : "2012",
    "format" : "pdf",
    "language" : "en",
    "rights" : "GPLv2",
    "description" : "",
    "creators" : [ {
      "uri" : "http://drinventor/Alec R.-Rivers",
      "name" : "Alec R.",
      "surname" : "Rivers"
    }, {
      "uri" : "http://drinventor/Andrew-Adams",
      "name" : "Andrew",
      "surname" : "Adams"
    }, {
      "uri" : "http://drinventor/Fr?do-Durand",
      "name" : "Fr?do",
      "surname" : "Durand"
    } ]
  },
  "bagOfWords" : [ "user", "adjust", "model", "use", "guidance", "iterate", "make", "shape", "physical", "object", "approach", "target", "3d", "model", "over", "time", "we", "show", "how", "approach", "can", "use", "create", "duplicate", "exist", "object", "scan", "object", "use", "scan", "target", "shape", "user", "free", "make", "reproduction", "different", "scale", "out", "different", "material", "we", "turn", "toy", "car", "cake", "we", "demonstrate", "end-to-end", "system", "which", "real-world", "performance", "capture", "datum", "retarget", "claymation", "we", "approach", "allow", "user", "easily", "accurately", "create", "complex", "shape", "naturally", "support", "large", "range", "material", "model", "size", "keyword", "personal", "digital", "fabrication", "spatially", "augment", "reality", "sculpt", "Rivers", "a.", "Adams", "A.", "Durand", "F.", "2012", "sculpt", "number", "ACM", "Trans", "31", "Article", "157", "-lrb-", "November", "2012", "-rrb-", "page", "dous", "10.1145", "2366145.2366176", "http://doi.acm.org/10.1145/2366145.2366176", "most", "people", "find", "challenge", "sculpt", "carve", "manually", "form", "precise", "shape", "we", "argue", "usually", "because", "lack", "manual", "dexterity", "average", "person", "able", "perform", "very", "precise", "manipulation", "rather", "because", "lack", "precise", "3d", "information", "can", "figure", "out", "what", "need", "do", "modify", "work", "progress", "order", "reach", "goal", "shape", "user", "follow", "guidance", "adjust", "object", "rescan", "when", "necessary", "bring", "object", "closer", "target", "shape", "over", "time", "we", "demonstrate", "application", "reproduce", "exist", "physical", "object", "different", "scale", "use", "different", "material", "start", "from", "depth", "video", "record", "Kinect", "we", "produce", "claymation", "physically", "correct", "dynamics", "multi-material", "fabrication", "device", "particularly", "challenging", "support", "artist", "build", "painting", "out", "layer", "include", "show", "how", "orient", "brush", "certain", "stage", "explicitly", "help", "task", "mix", "paint", "achieve", "desire", "color", "shadowdraw", "-lsb-", "Lee", "et", "al.", "2011", "-rsb-", "propose", "more", "open-ended", "system", "which", "user", "allow", "draw", "freely", "while", "shadow", "image", "suggestive", "contour", "update", "display", "behind", "sketch", "illustrate", "possible", "sketch", "completion", "while", "we", "interested", "challenge", "create", "physical", "sculpture", "from", "virtual", "model", "complementary", "challenge", "create", "virtual", "model", "use", "physical", "object", "input", "method", "have", "also", "be", "explore", "examine", "illumination", "single", "camera", "pixel", "across", "all", "project", "pattern", "one", "can", "determine", "coordinate", "projector", "pixel", "image", "camera", "pixel", "while", "basic", "approach", "straightforward", "number", "factor", "can", "create", "incorrect", "correspondence", "first", "some", "camera", "pixel", "may", "image", "part", "scene", "illuminate", "projector", "all", "can", "detect", "exclude", "ignore", "pixel", "do", "vary", "substantially", "between", "image", "which", "projector", "display", "entirely", "white", "entirely", "black", "camera", "pixel", "vary", "appropriately", "between", "white", "black", "projector", "image", "corresponding", "projector", "pixel", "can", "compute", "they", "however", "invalid", "correspondence", "corrupt", "depth", "map", "projector", "pixel", "ray", "do", "approximately", "intersect", "may", "case", "camera", "see", "reflection", "we", "reject", "correspondence", "achieve", "we", "must", "resample", "correspondence", "projector?s", "point", "view", "however", "complete", "model", "must", "correct", "from", "all", "side", "challenge", "rotate", "target", "model", "partial", "sculpture", "same", "amount", "about", "same", "axis", "rotation", "so", "user", "can", "continue", "without", "invalidate", "work", "already", "do", "process", "computer?s", "ability", "accurately", "detect", "absolute", "3d", "shape", "world", "coordinate", "mean", "guidance", "can", "rely", "upon", "achieve", "correct", "relative", "position", "size", "feature", "model", "which", "can", "otherwise", "extremely", "challenge", "novice", "sculptor", "less", "obvious", "important", "way", "which", "we", "benefit", "from", "have", "artist", "-lrb-", "even", "novice", "one", "-rrb-", "loop", "user", "can", "make", "unprompted", "change", "model", "achieve", "desire", "aesthetic", "appearance", "detail", "often", "essential", "aesthetic", "appearance", "model", "difficult", "replicate", "simple", "depth", "feedback", "may", "finer", "than", "scan", "can", "resolve", "may", "hide", "low-frequency", "depth", "discrepancy", "although", "larger", "can", "ignore", "therefore", "user", "typically", "finish", "model", "switch", "edge", "guidance", "mode", "minimize", "problem", "alteration", "one", "side", "affect", "already-completed", "region", "another", "because", "we", "use", "point", "cloud", "recover", "scanning", "algorithm", "directly", "we", "able", "sidestep", "difficulty", "edge", "case", "attempt", "reconstruct", "full", "3d", "mesh", "from", "scan", "put", "another", "way", "while", "skilled", "artist", "may", "able", "make", "plausible", "reproduction", "single", "pose", "human", "act", "run", "even", "skilled", "artist", "may", "have", "trouble", "determine", "how", "much", "adjust", "model", "make", "correspond", "pose", "runner", "exactly", "1/30th", "second", "later", "test", "we", "build", "end-to-end", "system", "which", "performance", "capture", "kinect", "use", "make", "claymation", "sequence", "-lrb-", "figure", "-rrb-", "reconstruct", "exist", "physical", "object", "we", "have", "advantage", "point", "cloud", "derive", "from", "Kinect", "can", "use", "directly", "modeling", "without", "need", "generate", "explicit", "3d", "mesh", "each", "frame", "model", "proceeds", "normal", "addition", "ability", "toggle", "between", "frame", "take", "snapshot", "scene", "save", "frame", "animation" ],
  "content" : "The user adjusts the model using the guidance and iterates, making the shape of the physical object approach that of the target 3D model over time. We show how this approach can be used to create a duplicate of an existing object, by scanning the object and using that scan as the target shape. The user is free to make the reproduction at a different scale and out of different materials: we turn a toy car into cake. We demonstrate an end-to-end system in which real-world performance capture data is retargeted to claymation. Our approach allows users to easily and accurately create complex shapes, and naturally supports a large range of materials and model sizes. Keywords: personal digital fabrication, spatially augmented reality, sculpting Rivers, A., Adams, A., Durand, F. 2012. Sculpting by Numbers. ACM Trans. 31 6, Article 157 (November 2012), 7 pages. DOI = 10.1145/2366145.2366176 http://doi.acm.org/10.1145/2366145.2366176. Most people find it challenging to sculpt, carve or manually form a precise shape. We argue that this is usually not because they lack manual dexterity ? the average person is able to perform very precise manipulations ? but rather because they lack precise 3D information, and cannot figure out what needs to be done to modify a work in progress in order to reach a goal shape. The user follows this guidance to adjust the object and rescans when necessary, bringing the object closer to the target shape over time. We demonstrate an application to reproducing an existing physical object at a different scale or using different materials. Starting from a depth video recorded with a Kinect, we produce claymation with physically correct dynamics. Multi-material fabrication with these devices is particularly challenging. They support the artist in building a painting out of layers, including showing how to orient the brush at certain stages, and explicitly help with the task of mixing paint to achieve a desired color. ShadowDraw [Lee et al. 2011] proposed a more open-ended system in which a user is allowed to draw freely while a ?shadow image? of suggestive contours is updated and displayed behind the sketch to illustrate possible sketch completions. While we are interested in the challenge of creating physical sculptures from a virtual model, the complementary challenge of creating virtual models using physical objects as an input method has also been explored. By examining the illumination of a single camera pixel across all projected patterns, one can determine the X and Y coordinate of the projector pixel that was imaged by that camera pixel. While the basic approach is straightforward, a number of factors can create incorrect correspondences. First, some camera pixels may image parts of the scene that are not illuminated by the projector at all. These can be detected and excluded by ignoring pixels that do not vary substantially between images in which the projector displays entirely white and entirely black. These camera pixels will vary appropriately between white and black projector images, and a corresponding projector pixel can be computed for them; however, this invalid correspondence will corrupt the depth map at that projector pixel. If the rays do not approximately intersect, as may be the case if the camera is seeing a reflection, we reject the correspondence. To achieve this, we must resample the correspondence into the projector?s point of view. However, a complete model must be correct from all sides. The challenge is to rotate the target model and the partial sculpture by the same amount about the same axis of rotation so the user can continue without invalidating work already done. In this process, the computer?s ability to accurately detect absolute 3D shape in world coordinates means that the guidance can be relied upon to achieve the correct relative positions and sizes of features of the model, which can otherwise be extremely challenging for a novice sculptor. A less obvious but important way in which we benefit from having an artist (even if a novice one) ?in the loop? is that the user can make unprompted changes to the model to achieve a desired aesthetic appearance. These details are often essential to the aesthetic appearance of a model, but are difficult to replicate with simple depth feedback: they may be finer than the scan can resolve, or may be hidden by low-frequency depth discrepancies that, although larger, can be ignored. Therefore, users will typically finish a model by switching to edge guidance mode. This minimizes the problem of alterations to one side affecting already-completed regions of another. Because we use the point cloud recovered by the scanning algorithm directly, we are able to sidestep the difficulties and edge cases of attempting to reconstruct a full 3D mesh from a scan. Put another way, while a skilled artist may be able to make a plausible reproduction of a single pose of a human in the act of running, even that skilled artist may have trouble determining how much to adjust the model to make it correspond to the pose of that runner exactly 1/30th of a second later. To test this, we built an end-to-end system in which a performance is captured by a Kinect and used to make a claymation sequence ( Figure 5 ). As with reconstructing an existing physical object, we have the advantage that the point cloud derived from the Kinect can be used directly for modeling, without needing to generate an explicit 3D mesh for each frame. Modeling proceeds as normal, with the addition of the ability to toggle between frames and to take a snapshot of the scene to save as a frame of the animation.",
  "resources" : [ ]
}